import pygame
import random
import sys

pygame.init()
WIDTH, HEIGHT = 640, 480
win = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Recursion Rectangles")

RED = (255, 0, 0)

def draw_rect(win, count):
    if count <= 0:
        return

    print("drawRectangle is called")
    rect_width, rect_height = 40, 40
    x = random.randint(0, WIDTH - rect_width)
    y = random.randint(0, HEIGHT - rect_height)
    pygame.draw.rect(win, RED, (x, y, rect_width, rect_height), width=1)

    draw_rect(win, count - 1)

def main():
    win.fill((255, 255, 255))
    draw_rect(win, 500)
    pygame.display.flip()

    # Event Loop
    running = True
    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False

    pygame.quit()
    sys.exit()

if __name__ == "__main__":
    main()