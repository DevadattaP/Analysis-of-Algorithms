# Write a python Program to perform various operation on stack using Stack class
class Stack:
    def __init__(self):
        self.stack = list()
        print('stack created\n')

    def is_empty(self):
        return self.stack == []
    def push(self, value):
        if value is None:
            return False
        else:
            self.stack.insert(0, value)
        return True

    def peek(self):
        if not self.is_empty():
            return self.stack[0]
        else:
            return False

    def pop(self):
        if self.stack:
            return self.stack.pop(0)
        else:
            return False

    def clear(self):
        self.stack = list()
        print('stack cleared\n')

    def display(self):
        print("Stack contains: ", self.stack,"\n")


s = Stack()

while True:
    print('***** MENU *****')
    print('1. PUSH\n2. POP\n3.PEEK\n4.DISPLAY\n5.FLUSH\n6.EXIT')
    option = int(input('Enter your option: '))
    if option == 1:
        val = int(input('Enter number to push on stack: '))
        if s.push(val):
            print(val, 'pushed\n')
        else:
            print('Unable to push\n')
    elif option == 2:
        val = s.pop()
        if val:
            print(val, 'popped\n')
        else:
            print('Unable to pop\n')
    elif option == 3:
        val = s.peek()
        if val:
            print('top element = ', val,"\n")
        else:
            print('No element\n')
    elif option == 4:
        s.display()
    elif option == 5:
        s.clear()
    else:
        break
