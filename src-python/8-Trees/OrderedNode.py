# necessary before python 3.14 to use type hints for enclosing classes
from __future__ import annotations
from Node import Node

class OrderedNode(Node):
    ''' An ordered tree means, it's children are in an order (e.g. number, alphabetical, ..) '''

    def __init__(self, element: str):
        super().__init__(element)

    def add_child(self, child: Node):
        inserted = False
        for i, current in enumerate(self.children):
            if current.get_element() > child.get_element():
                self.children.insert(i, child)
                inserted = True
                break
        if not inserted:
            self.children.append(child)
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
    root = OrderedNode("Adam")
    node1 = OrderedNode("Abel")
    root.add_child(node1)
    node2 = OrderedNode("Cain")
    root.add_child(node2)
    root.add_child(OrderedNode("Bert"))
    node2.add_child(OrderedNode("Citha"))
    node2.add_child(OrderedNode("Maac"))

    print("Children of Adam (get_children):", [str(child) for child in root.get_children()])
    print("Parent of Cain (get_parent):", node2.get_parent())
    print("Is Adam root (is_root):", root.is_root())
    print("Is Cain internal (is_internal):", node2.is_internal())
    print("Is Cain external (is_external):", node2.is_external())
    print("Data element of Cain (get_element):", node2.get_element())

    print("\nPre-Order Traversal: ")
    root.pre_order_traversal()

    print("\nPost-Order Traversal: ")
    root.post_order_traversal()

    print("\nLevel-Order Traversal: ")
    for height in range(1, 4):
        root.level_order(height)