package com.github.barakb.lec1.hellow


/**
  * Created by Barak Bar Orion
  * on 7/20/16.
  *
  * @since 12.0
  */
object Main {
  def main(args: Array[String]): Unit = {

    val oneTwo = List(1, 2)

    val threeFour = List(3, 4)

    val restList = List(5,6,7,8,9)

    val oneToTen = oneTwo ::: threeFour ::: restList

    val oneTwoThreeFour = oneTwo ::: threeFour

    println( oneTwo :: threeFour)
    println( oneTwoThreeFour)

    val fruits = "plumes" :: ( "apples" :: ("oranges" :: ("pears" :: Nil)))
    println( fruits)

    //flatMap
    println("flatMap1=" +  fruits.flatMap(_.toUpperCase))

    def toInt(s: Int): Option[Int] = {
      try {
        Some(2*s)
      } catch {
        // catch Exception to catch null 's'
        case e: Exception => None
      }
    }

    //flatMap
    println("flatMap2=" + oneTwoThreeFour.flatMap(toInt))

    def g(v:Int) = List(v-1, v, v+1)
    println("map=" + oneTwo.map(x => g(x)) )
    println("flatMap3=" + oneTwo.flatMap(x => g(x)) )


    println( "Tail:" + fruits.tail );
    println( "Head:" + fruits.head );
    println( "isEmpty:" + fruits.isEmpty );
    println( "exists:" + fruits.exists(_=="apples") );
    println( "count:" + fruits.count(_=="apples") );
    println( "size:" + fruits.size );
    //sort
    println( "sortWith1:" + fruits.sortWith(_ < _) )
    println( "sortWith2:" + fruits.sortWith(_ > _) )
    println( "sortWith3:" + fruits.sortWith((_.length()>_.length())) )
    //collect
    val collectResults = fruits collect {
      case s2: String => "String2:" + s2
      case apples: String => "String1:" + apples
    }
    println( "collect:" + collectResults )

    //map
    println("map1:" + oneTwo.map( x => x*2 ) )
    println("map2:" + fruits.map( x => x*4 ) )//!!!!!
    println( "map3" + fruits.map(_.toUpperCase) )
    println( "map4" + fruits.map( x=> x.toUpperCase) )

    //drop
    println( "Dropped:" + fruits.drop( 1 ) )

    //filter
    println( "Filter:" + fruits.filter( _ == "apples" ) )
    println( "Filter:" + fruits.filter( _ == "apples" ) )


    var myReversedList = fruits.reverse

    //reverse
    println( "Reverse:" + fruits.reverse )
    println( "myReversedList:" + myReversedList )

    //mkString
    println( "mkString:" + fruits.mkString( "_!__" ) )

    //foreach
    fruits.foreach( x => println( "element:" + x ) )


    //yield
    println( "yield1:" +( for (i <- 1 to 5) yield i ) )
    println( "yield2:" +( for (i <- 1 to 5) yield i*2 ) )
    println( "yield3:" +( for (i <- 1 to 5) yield i%2 ) )

    println( "yield4:" + (for (e <- fruits) yield e ) )
    println( "yield5:" + ( for (e <- oneTwoThreeFour) yield e*2 ) )
    println( "yield6:" + ( for (e <- oneToTen if e > 4) yield e ) )


    def myFruites =
      for{file <- fruits
        if file.endsWith("es")} yield file
    println( myFruites )


    //flat map
/*
    oneTwo.flatMap( x => x*2 )
    println("flatmap1:" + oneTwo.map( x => x*2 ) );
*/

  //partial functions

    val two: PartialFunction[Int, String] = { case 2 => "two" }
    val three: PartialFunction[Int, String] = { case 3 => "three" }
    val wildcard: PartialFunction[Int, String] = { case _ => "something else" }

    println( "PartialFunction1" + two( 2 ) )
    println( "PartialFunction2" +  three( 3 ) )
    println( "PartialFunction3" + wildcard( 55562309 ) )

    val fraction = new PartialFunction[Int, Int] {
      def apply(d: Int) = 42 / d
      def isDefinedAt(d: Int) = d != 0
    }

    println( "Fraction applye:" + fraction.apply( 1 ) )
    println( "Fraction iSdefinedAt1:" + fraction.isDefinedAt( 0 ) )
    println( "Fraction iSdefinedAt2:" + fraction.isDefinedAt( 1 ) )



    //pattern matching

    val firstArg = if (!args.isEmpty) args(0) else "salt"
    val friend =
      firstArg match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
      }

    friend
    println( friend )
/*

    abstract class Expr
    case class Var(name: String) extends Expr
    case class Number(num: Double) extends Expr
    case class UnOp(operator: String, arg: Expr) extends Expr
    case class BinOp(operator: String,
                     left: Expr, right: Expr) extends Expr

    val op = BinOp("+", Number(1), Var("ddd"))
    println("Op:" + op)



    def simplifyTop(expr: Expr): Expr = expr match {
      case UnOp("-", UnOp("-", e))
      => e
      // Double negation
      case BinOp("+", e, Number(0)) => e // Adding zero
      case BinOp("*", e, Number(1)) => e
      case _ => expr // Multiplying by one
    }

    println( simplifyTop( UnOp( "mysimplify", Number(1) ) ) );*/

  }



}
