import re


def number_fillter(input_text):
    # 연속된 숫자 필터
    nf = re.compile("(\d{8,20})")
    # 휴대폰번호 필터
    pn = re.compile("(\d{2,6}[ -]-?\d{2,6}[ -]-?\d{2,6})")
    # 계좌번호 필터
    ac = re.compile("(\d{2,6}[ -]-?\d{2,6}[ -]-?\d{2,6}[ -]-?\d{2,6})")

    # 검색
    if pn.search(input_text):
        return 1
    elif ac.search(input_text):
        return 2
    elif nf.search(input_text):
        return 3
    else:
        return 0


print(number_fillter(str(12345678)))

