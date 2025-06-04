# necessary before python 3.14 to use type hints for enclosing classes
from __future__ import annotations
from Node import Node

class OrderedNode(Node):
    ''' An ordered tree means, it's children are in an order (e.g. number, alphabetical, ..) '''

    def __init__(self, element: str):
        super().__init__(element)

    def add_child(self, child: Node):
        self.children.append(child)
        self.children = sorted(self.children)
        child.parent = self

    def pre_order_traversal(self):
        ''' Print this node before its children. '''
        print(self.element)
        for child in self.children:
            if isinstance(child, OrderedNode):
                child.pre_order_traversal()

    def post_order_traversal(self):
        ''' Print the children and then this node.'''
        for child in self.children:
            if isinstance(child, OrderedNode):
                child.post_order_traversal()
        print(self.element)

    def level_order(self, level: int):
        ''' Print all nodes on one level of the tree. '''
        if level == 1:
            print(self.element)
        elif level > 1:
            for child in self.children:
                if isinstance(child, OrderedNode):
                    child.level_order(level - 1)


if __name__ == "__main__":
    root = OrderedNode("Earth")
    node1 = OrderedNode("Africa")
    root.add_child(node1)
    node2 = OrderedNode("Asia")
    node3 = OrderedNode("Europe")
    root.add_child(node2)
    root.add_child(node3)
    node3.add_child(OrderedNode("France"))
    node3.add_child(OrderedNode("Spain"))
    node3.add_child(OrderedNode("UK"))

    print("Children of Earth (get_children):", [str(child) for child in root.get_children()])
    print("Parent of Asia (get_parent):", node2.get_parent())
    print("Is Earth root (is_root):", root.is_root())
    print("Is Europe internal (is_internal):", node3.is_internal())
    print("Is Europe external (is_external):", node3.is_external())
    print("Data element of Asia (get_element):", node2.get_element())

    print("\nPre-Order Traversal: ")
    root.pre_order_traversal()

    print("\nPost-Order Traversal: ")
    root.post_order_traversal()

    print("\nLevel-Order Traversal: ")
    for height in range(1, 4):
        root.level_order(height)