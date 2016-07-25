/**
  * Created by Barak Bar Orion
  * on 7/24/16.
  *
  * @since 12.0
  */
object Option1 {

  sealed abstract class Option[+A]{
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(a) => Some(f(a))
    }

    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(a) => a
    }

    def flatMap[B](f: A => Option[B]): Option[B]= this match {
      case None => None
      case Some(a) => f(a)
    }

    def orElse[B >: A](ob: => Option[B]): Option[B] = this match{

      case Some(a) => Some(a)
      case None => ob
    }

    def filter(f: A => Boolean): Option[A] = this match{
      case Some(a) if( f(a)) => Some(a)
      case _ => None
    }

    def lift[A,B](f: A => B): Option[A] => Option[B] = {
      def fun = ( a:Option[A] ) => a.map( f )
      fun
    }

    //def sequence[A](a: List[Option[A]]): Option[List[A]]

  }

  object None extends Option[Nothing]
  case class Some[A](get : A) extends Option[A]


  def main(args: Array[String]): Unit = {

    def mean(xs: Seq[Double]): Option[Double] =
      if (xs.isEmpty) None
      else Some(xs.sum / xs.length)
  }

}
