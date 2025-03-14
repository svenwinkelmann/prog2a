import random
import pygame

class Game:

    SIZE = (320, 240)
    FPS = 30

    def __init__(self):
        self.clock = pygame.time.Clock()
        screen = self.init_game()
        self.game_loop(screen)
        self.exit_game()

    def init_game(self):
        random.seed()
        pygame.init()
        screen = pygame.display.set_mode(self.SIZE)
        return screen

    def game_loop(self, screen):
        while True:
            if not self.event_handling():
                break
            if not self.update_game():
                break
            self.draw_game(screen)
            self.clock.tick(self.FPS)

    def event_handling(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return False
        keys = pygame.key.get_pressed()
        # TODO: implement key events
        return True

    def update_game(self):
        # TODO: implement game logic
        return True

    def draw_game(self, screen):
        screen.fill((0, 0, 0)) # black background
        # TODO: draw logic
        pygame.display.flip()

    def exit_game(self):
        pygame.quit()


# Program start
if __name__ == "__main__":
    game = Game()