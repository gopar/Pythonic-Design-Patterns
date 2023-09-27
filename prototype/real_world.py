import copy

class Sprite:
    def __init__(self, image_file):
        self.image = self.load_image(image_file)

    def load_image(self, image_file):
        # Simulate the "heavy" operation of loading an image
        return f"Image data from {image_file}"

    def clone(self):
        return copy.deepcopy(self)

# Create an original sprite (this would load the image)
original_sprite = Sprite("large_image_file.png")

# Clone the sprite (this won't reload the image)
cloned_sprite = original_sprite.clone()

# Confirm that the cloned sprite has the same image data
print(cloned_sprite.image)
