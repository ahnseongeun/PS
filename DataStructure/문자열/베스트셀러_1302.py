n = int(input())

books = {}
for _ in range(n):
    bookName = input()
    if bookName in books:
        books[bookName] += 1
    else:
        books[bookName] = 1

maxValue = max(books.values())
bestSeller = []
for book, number in books.items():
    if number == maxValue:
        bestSeller.append(book)

print(sorted(bestSeller)[0])