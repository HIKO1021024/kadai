//ライブラリ等の指示はなかったため、breezeを使わせて頂きます。
//数字以外の値が入力されていた際のエラー処理はしておりません。
//出力される解は整数で出力するべきかどうかわからないため、現時点では丸めておりません

import breeze.linalg._
import scala.util.Random

  object Renritu{
    def main(args: Array[String]){
      //乱数生成用
      val r = new Random
      //ax+by=c
      //dx+ey=f
      var (a,b,c,d,e,f) = (r.nextInt,r.nextInt,r.nextInt,r.nextInt,r.nextInt,r.nextInt)
      //var (a,b,c,d,e,f) = (1,2,-1,2,4,-2) //テストパターン:解が存在しない
      //var (a,b,c,d,e,f) = (1,1,1,1,1,2)  //テストパターン:解が複数ある
      var g = DenseVector(a.toDouble, d.toDouble)  
      var h = DenseVector(b.toDouble, e.toDouble)  
      var i = DenseVector(c.toDouble, f.toDouble)  
      var (x, y) = Renritu_cul(g, h, i)
      //計算したx,yの結果により出力を変える
      println("x =" + x,"y=" + y) //一応出力
      (x.toString, y.toString) match {
        case ("-Infinity","Infinity") => println("解が存在しません")
        case ("NaN","NaN") => println("解が複数あります")
        case _ => println("x =" + x,"y=" + y)
      }
    }
   
    def Renritu_cul(g: DenseVector[Double], h: DenseVector[Double], i: DenseVector[Double]): (Double, Double) = {   
       var x = det(DenseMatrix(i, h)) / det(DenseMatrix(g, h))  
       var y = det(DenseMatrix(g, i)) / det(DenseMatrix(g, h))  
       (x, y)  
    }
  }
  
  //参考にしたサイトなど
  //http://proofcafe.org/k27c8/math/math/liner_algebraI/page/transformation_of_vector_by_matrix/
  //https://www.youtube.com/watch?v=ESzPIqpwRxQ
  //http://www.geisya.or.jp/~mwm48961/kou2/linear_eq1.html
  //https://qiita.com/TakashiOshikawa/items/20ba0e50d59b1b5ef93c
  //http://modegramming.blogspot.jp/2016/05/breeze.html
  //http://d.hatena.ne.jp/kaishitaeiichi/20120805/1344180433