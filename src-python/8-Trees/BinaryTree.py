# necessary before python 3.14 to use type hints for enclosing classes
from __future__ import annotations
from Finisher import Finisher
from BinaryNode import BinaryNode

class BinaryTree:

    def add_finisher(self, node: BinaryNode, finisher: Finisher) -> BinaryNode:
        '''
        A binary tree has one left and one right subtree. While adding finishers we
        sort the tree based on the finishing time of the finisher.
        :param node: current node
        :param finisher: data element
        :return: current node
        '''''
        if node is None:  # base case
            return BinaryNode(finisher)

        if node.element.time > finisher.time:
            node.left = self.add_finisher(node.left, finisher)  # recursive case for left subtree
        else:
            node.right = self.add_finisher(node.right, finisher)  # recursive case for right subtree

        return node

    def print_result_table(self, node: BinaryNode):
        '''
        In order traversal gives us a sorted output :)
        :param node: start node. We can print subtrees, too.
        '''
        if node is not None:  # base case
            self.print_result_table(node.left)  # recursive case for left subtree
            print(node.element)
            self.print_result_table(node.right)  # recursive case for right subtree


if __name__ == "__main__":
    # let's start the snail race: https://www.youtube.com/watch?v=zbEeeJmYoAk
    snail_race_results = BinaryTree()
    root = None

    root = snail_race_results.add_finisher(root, Finisher("Hubert", 34.1))
    snail_race_results.add_finisher(root, Finisher("Linda", 54.2))
    snail_race_results.add_finisher(root, Finisher("Sam", 36.1))
    snail_race_results.add_finisher(root, Finisher("Frank", 25.0))
    snail_race_results.add_finisher(root, Finisher("Peter", 86.5))
    snail_race_results.add_finisher(root, Finisher("Paul", 74.3))
    snail_race_results.add_finisher(root, Finisher("Vera", 95.3))
    snail_race_results.add_finisher(root, Finisher("Lina", 47.4))
    snail_race_results.add_finisher(root, Finisher("Hans", 185.6))
    snail_race_results.add_finisher(root, Finisher("Klaus", 55.4))
    snail_race_results.add_finisher(root, Finisher("Max", 23.3))
    snail_race_results.add_finisher(root, Finisher("Moritz", 63.6))
    snail_race_results.add_finisher(root, Finisher("Ina", 452.4))

    print("Ergebnisliste (nach Zeit sortiert):\n")
    snail_race_results.print_result_table(root)
