
class Rational(num : Int, den : Int) {
	require(den != 0)
	def this(num : Int) = this(num,1)

	private var numer = num
	private var denom = den

	def +(to : Rational) = new Rational((numer * to.denom) + (denom * to.numer),denom * to.denom)
	def +(to : Int) = {
		val t = new Rational(to)
		new Rational((numer * t.denom) + (denom * t.numer),denom * t.denom)
	}
	
	def -(from : Rational) = new Rational((numer * from.denom) - (denom * from.numer),denom * from.denom)
	def -(from : Int) =  {
		val frm = new Rational(from)
		new Rational((numer * frm.denom) - (denom * frm.numer),denom * frm.denom)
	}

	def *(to :  Rational) = new Rational(numer * to.numer,denom * to.denom )
	def *(to :  Int) = new Rational(numer * to,denom  )

	def /(from : Rational) = *(from.inv)
	def /(from : Int) = *((new Rational(from)).inv)
	
	def inv() : Rational = new Rational(denom,numer)
	
	def normalize() : Rational = {
		def gcd(n1 : Int,n2 : Int) : Int = {
			def gcd(d : Int) : Int = if (n1 % d == 0 && n2 % d == 0) d else gcd(d-1)
			gcd(n1.min(n2))		
		}
		val d = gcd(numer,denom)
		new Rational(numer/d , denom/d)
	}

	override def toString() = s"${numer}/${denom}"
}

