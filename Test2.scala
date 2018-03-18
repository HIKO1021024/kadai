//おそらくこの問題はいわゆる「組み合わせ」を問うものだと想定される。
//よって母数を限りなく減らした上で、組み合わせのリストを生成し、
//そのリストからA[i]<A[j]を精査する方法が効率が良い。
//精査する方法だが
//与えられる配列は必ず2要素以上入っているものを想定している

import scala.util.Random

  object Kumiawase{
    def main(args: Array[String]){
        //まずはランダムな配列Aを作成
        val r = new Random
        var A: Array[Int] = Array.empty
        for(i <- 0 to 3000) A = A :+ r.nextInt(100)
        //Kも生成
        val K = r.nextInt(100)
        //重複はSet型に変換し削除する
        var B: Set[Int] = A.toSet
        //combinationsはSetでは使えないのでArray型に戻す
        A = B.toArray
        //配列の最低値を取得
        val mn = A.min;
        //0+(最低値)よりも大きな数値は明らかに条件に合致しないため、削除する
        if(mn < 0) {
          //最低値が負の数字の場合
          A = A.filter(_ <= 0+(mn * -1) );
        }else {
          //そうでない場合
          A = A.filter(_ <= 0 + mn );
        }
        //Aの中から組み合わせを作成
        var B = A.combinations(2).toArray
        //組み合わせの中から条件に合致する数値が存在するか調べる
    }
       
    //def Rand_arr(valmin: Long, valmax: Long, arry_max: Long):Array[;] = {
    //  return a = (1,2,4,7,8)
    //}
    
    def Arrygen(valmax: Int,arry_max: Int):Array[Int] = {
      
    }
  }
   