from threading import Thread


class MakeTea(Thread):
    def make_tea(self):
        self.s1()
        self.s2()
        self.s3()
        self.s4()
        self.s5()
        self.s6()

    def s1(self):
        print("Fill up the kettle with water...")

    def s2(self):
        print("Add sugar in it...")

    def s3(self):
        print("Add tea powder in it...")

    def s4(self):
        print("Add milk to it...")

    def s5(self):
        print("Boil for some time...")

    def s6(self):
        print("Enjoy ☕︎")


mt = MakeTea()  # create instance
t = Thread(target=mt.make_tea)  # create thread
t.start()   # run thread
