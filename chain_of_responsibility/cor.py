class Middleware:
    def __init__(self, next_middleware=None):
        self.next_middleware = next_middleware

    def handle_request(self, request):
        if self.next_middleware:
            return self.next_middleware.handle_request(request)
        return "Final Response"


class AuthMiddleware(Middleware):
    def handle_request(self, request):
        if request.get("auth_token") != "valid_token":
            return "Unauthorized"
        print("Auth Middleware: Passed")
        return super().handle_request(request)


class LoggingMiddleware(Middleware):
    def handle_request(self, request):
        print(f"Logging Middleware: {request}")
        return super().handle_request(request)


class CacheMiddleware(Middleware):
    def handle_request(self, request):
        if request.get("use_cache"):
            return "Cached Response"
        print("Cache Middleware: Passed")
        return super().handle_request(request)


# Build the middleware chain
middleware_chain = AuthMiddleware(
    next_middleware=LoggingMiddleware(
        next_middleware=CacheMiddleware()
    )
)

# Create some sample requests
request1 = {"auth_token": "valid_token", "use_cache": True}
request2 = {"auth_token": "invalid_token"}
request3 = {"auth_token": "valid_token", "use_cache": False}

# Handle requests
print(middleware_chain.handle_request(request1))  # Should return "Cached Response"
print(middleware_chain.handle_request(request2))  # Should return "Unauthorized"
print(middleware_chain.handle_request(request3))  # Should return "Final Response"
