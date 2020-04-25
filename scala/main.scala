object main {

	implicit def intToRational(n : Int) = new Rational(n)
	
	def main(args : Array[String]) {
		val r1 = 3
		val r2 = new Rational(2,3)

		println(s"${r1} + ${r2} ==> "+ (r1 + r2))
		println(s"${r1} - ${r2} ==> "+ (r1 - r2))
		println(s"${r1} * ${r2} ==> "+ (r1 * r2))
		println(s"${r1} + ${r2} ==> "+ (r1 / r2))
		println("Inv :"+r1.inv)
	}
}