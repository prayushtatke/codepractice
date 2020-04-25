#!/bin/bash
exec scala "$0" "$@"
!#

// GCD
// def gcd(n1 : Int,n2 : Int) : Int = {
// 	def gcd(d : Int) : Int = if (n1 % d == 0 && n2 % d == 0) d else gcd(d-1)
// 	gcd(n1.min(n2))		
// }

// println("gcd of " + args(0)+" , "+args(1) +": "+gcd(args(0).toInt,args(1)toInt))

def printArr(arr : Array[Int]) : Unit = {
	arr.foreach( i => print(i + " "))
	println()
}

// bubble sort approach 1
def bubblesort(arr : Array[Int]) = {
	var tmp = 0
	for (e <- arr.length - 1 to 1 by -1) {
		for(i <- 0 until e) {
			if (arr(i) > arr(i+1)) {
				tmp = arr(i)
				arr(i) = arr(i+1)
				arr(i+1) = tmp
			}
			// printArr(arr)
		}
	}
	arr
}

println("Before")
val before = Array(4,2,5,3,9,8,1,6)
println(before.mkString(","))
println("After")
val after  = bubblesort(before)
println(after.mkString(","))

