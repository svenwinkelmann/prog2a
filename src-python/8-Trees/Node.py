# necessary before python 3.14 to use type hints for enclosing classes
from __future__ import annotations

class Node:
    '''
     In this class, we build up a data structure called tree. Therefore, we implement a simple
     data structure Node, which has a parent and 0 to n children.
     Usually a node of a tree consists of:
      - a parent / ancestor of type Node
      - a data element (in this case a string, could be an int, boolean, or any complex data)
      - 0 to n children of type Node
    '''

    def __init__(self, name: str):
        '''
        The constructur initializes the children list and the data element
        @param name data element to save in the Node
        '''
        self.parent = None
        self.element = name
        self.children = []

    def add_child(self, child: Node):
        '''
        Adds a child node to this node and references the parent correctly.
        Till now we have an unordered tree.
        @param child The node to add.
        '''
        child.parent = self
        self.children.append(child)

    def is_root(self) -> Node:
        '''
        A root node does not have a parent
        '''
        return self.parent is None

    def is_internal(self) -> bool:
        ''' An internal node has a parent and at least one child '''
        return self.parent is not None and len(self.children) > 0

    def is_external(self) -> bool:
        ''' An external node (also called leaf node) does not have children '''
        return len(self.children) == 0

    def get_element(self) -> str:
        '''
        Each node has a data element, which is returned by this function.
        We could make the instance variable public, but this is not a good
        programming style ;-).
        '''
        return self.element

    def get_parent(self) -> Node:
        return self.parent

    def get_children(self) -> list[Node]:
        return self.children

    def remove_child(self, node):
        '''
        Removes a child node. Be careful as the whole subtree of the child is removed, too.
        We cannot save any child after removing its parent, because we do not have any
        reference to it (except we save it before). And if there is no reference to an
        instance, the garbage collector removes the instance.
        '''
        self.children.remove(node)

    def __str__(self):
        return self.element

# Testmethoden
if __name__ == "__main__":
    root = Node("Earth")
    node1 = Node("Africa")
    root.add_child(node1)
    node2 = Node("Asia")
    node3 = Node("Europe")
    root.add_child(node2)
    root.add_child(node3)
    node3.add_child(Node("France"))
    node3.add_child(Node("Spain"))
    node3.add_child(Node("UK"))

    print("Children of Earth (get_children):", [str(child) for child in root.get_children()])
    print("Parent of Asia (get_parent):", node2.get_parent())
    print("Is Earth root (is_root):", root.is_root())
    print("Is Europe internal (is_internal):", node3.is_internal())
    print("Is Europe external (is_external):", node3.is_external())
    print("Data element of Asia (get_element):", node2.get_element())
    root.remove_child(node3)
    print("Removed Europe (remove_child):", [str(child) for child in root.get_children()])