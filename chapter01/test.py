# 初始化棋盘的每个格子都为"[]"
a = b = c = d = e = f = g = h = i = "[]"
# 将棋盘格子放入列表中，方便操作
li = [a, b, c, d, e, f, g, h, i]
# 记录游戏进行的轮数
time = 0
# 记录玩家落子位置的列表
pro = []
globals()


def clear_screen():
    # 清空屏幕，简单地输出多个空行
    print("\n" * 10)


def print_chessboard():
    # 打印棋盘
    print(li[0], "|", li[1], "|", li[2])
    print(li[3], "|", li[4], "|", li[5])
    print(li[6], "|", li[7], "|", li[8])


def action():
    while 1:
        pro_play = input("Do you want to activate a new mode? \n""if you want to try pleas print yes 1  or  no 0\n"
                         " out  2")
        if pro_play == "0":
            play()
        elif pro_play == "1":
            play_pro()
        elif pro_play == "2":
            break
        else:
            print("no")


def play():
    print_chessboard()
    times = 0
    win = 0
    while win == 0:
        if determine_win():
            break
        bake = (input('input'))
        if bake.isnumeric():  # 检查输入是否为数字
            bake = int(bake)
            if 0 < bake < 10:
                bake -= 1
                if times % 2 == 1:
                    if li[bake] == "[]":
                        li[bake] = "X "
                        clear_screen()
                        print(print_chessboard())
                        times += 1
                    else:
                        print('no')
                        continue
                if times == 10:
                    win += 1
                    print("no one win",
                          "end")
                    continue
                if times % 2 == 0:
                    if li[bake] == "[]":
                        li[bake] = "O "
                        clear_screen()
                        print(print_chessboard())
                        times += 1
                    else:
                        print('no')
                        continue
                if times == 10:
                    win += 1
                    print("no one win",

                          "end")
            else:
                print("no")
        else:
            print("no")


def play_pro():
    global pro
    z = 0
    print_chessboard()
    times: int = 0
    win = 0
    while win == 0:
        if determine_win():
            break
        if times > 5:
            print("now is time to delete")
            bake = (input('input'))
            if bake.isnumeric():  # 检查输入是否为数字
                bake = int(bake)
                li[pro[z]] = "[]"
                z += 1
                pro.append(bake - 1)
                if 0 < bake < 10:
                    bake -= 1
                    if times % 2 == 1:
                        li[bake] = "X "
                        clear_screen()
                        print("将要删除", pro[z+1])
                        print(print_chessboard())
                        times += 1
                        continue
                    if times % 2 == 0:
                        li[bake] = "O "
                        clear_screen()
                        print("将要删除", pro[z+1])
                        print(print_chessboard())
                        times += 1

            else:
                print("no")
        else:
            bake = (input('input'))
            if bake.isnumeric():  # 检查输入是否为数字
                bake = int(bake)
                pro.append(bake - 1)
                if 0 < bake < 10:
                    bake -= 1
                    if times % 2 == 1:
                        if li[bake] == "[]":
                            li[bake] = "X "
                            clear_screen()
                            print(print_chessboard())
                            times += 1
                        else:
                            print('no')
                            continue
                        continue
                    if times % 2 == 0:
                        if li[bake] == "[]":
                            li[bake] = "O "
                            clear_screen()
                            print(print_chessboard())
                            times += 1
                        else:
                            print('no')
                        continue

                else:
                    print("no")
            else:
                print("no")


def determine_win():
    if (li[0] == li[1] == li[2] == "X " or li[3] == li[4] == li[5] == "X " or li[6] == li[7] == li[8] == "X " or li[
                    0] == li[5] == li[8] == "X " or li[1] == li[4] == li[7] == "X " or li[2] == li[5] == li[8] == "X "
            or li[0] == li[4] == li[8] == "X " or li[2] == li[4] == li[6] == "X "):
        print("b win!", "end")

        return True

    elif li[0] == li[1] == li[2] == "O " or li[3] == li[4] == li[5] == "O " or li[6] == li[7] == li[8] == "O " or li[
          0] == li[5] == li[8] == "O " or li[1] == li[4] == li[7] == "O " or li[2] == li[5] == li[8] == "O " or li[
          0] == li[4] == li[8] == "O " or li[2] == li[4] == li[6] == "O ":
        print("a win!", "end")
        return True

    else:
        return False


action()
