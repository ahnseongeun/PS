allGrade = input()


def average(grade, operation):
    if operation == '+':
        return grade + 0.3
    elif operation == '0':
        return grade + 0.0
    else:
        return grade - 0.3

grade = allGrade[0]
result = 0.0
if grade != 'F':
    operation = allGrade[1]
    if grade == 'A':
        result = average(4.0, operation)
    elif grade == 'B':
        result = average(3.0, operation)
    elif grade == 'C':
        result = average(2.0, operation)
    elif grade == 'D':
        result = average(1.0, operation)
print(result)