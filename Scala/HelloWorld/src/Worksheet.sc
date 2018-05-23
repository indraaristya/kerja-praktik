def square(x: Int) = x*x
square(4)

val a = "Hello Scala"
a.size

val l = -3

a.toUpperCase()
a.take(5)
a.drop(6)

def cut(str: String, i: Int) = str.drop(i)
cut("Hello Scala",6)

def ifelses(x: Int) = if (x < 0) x else -x
ifelses(5)

val x = 9
val u = x + 1; u*u

def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b,a%b)

gcd(2,9)

var p = new Array[Int](9)
p(0) = 1
p.apply(0)

var q = Array(1,2)
q(1)