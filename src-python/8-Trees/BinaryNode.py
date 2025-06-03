# necessary before python 3.14 to use type hints for enclosing classes
from __future__ import annotations
from Finisher import Finisher

class BinaryNode:

    def __init__(self, finisher: Finisher):
        self.element = finisher
        self.left: BinaryNode = None
        self.right: BinaryNode = None