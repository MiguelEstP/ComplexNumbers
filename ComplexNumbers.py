c1 = complex(input("Type the first complex number: ").replace("i", "j"))
c2 = complex(input("Type the second complex number: ").replace("i", "j"))

soma = c1 + c2
subtracao = c1 - c2
multiplicacao = c1 * c2
c1_conjugado = complex.conjugate(c1)
c2_conjugado = complex.conjugate(c2)

print(c1, c2)
print(soma)
print(subtracao)
print(multiplicacao)
print(c1_conjugado)
print(c2_conjugado)
