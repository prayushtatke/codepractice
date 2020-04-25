// import scala.language.implicitConversions

object app extends App {

	implicit def intToRational(n : Int) = new Rational(n)
	
	val r1 = 3
	val r2 = new Rational(20,30)

	println(s"${r1} + ${r2} ==> ${r1 + r2}")
	println(s"${r1} - ${r2} ==> ${r1 - r2}")
	println(s"${r1} * ${r2} ==> ${r1 * r2}")
	println(s"${r1} + ${r2} ==> ${r1 / r2}")
	println("Inv :"+r1.inv)
	println("Normalize :"+r1.normalize)
}