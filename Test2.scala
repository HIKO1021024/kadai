//おそらくこの問題はいわゆる「組み合わせ」を問うものだと想定される。
//よって母数を限りなく減らした上で、組み合わせのリストを生成し、
//そのリストからA[i]<A[j]を精査する方法が効率が良い。
//精査する方法だが
//与えられる配列は必ず2要素以上入っているものを想定している

import scala.util.Random
import scala.util.control.Breaks

  object Kumiawase{
    def main(args: Array[String]){
      //まずはランダムな配列Aを作成
      val r = new Random
      var A: Array[Int] = Array.empty
      for(i <- 0 to 3000) A = A :+ r.nextInt(100)
      //Kも生成
      val K = r.nextInt(100)
      //重複は削除する
      A = A.distinct
      //配列の最低値を取得
      val mn = A.min;
      //最低値からKへの必要な数値を算出
      val T = K - mn 
      //0+(T+最低値)よりも大きな数値は明らかに条件に合致しないため、削除する
      if(mn < 0) {
        //最低値が負の数字の場合
        A = A.filter(_ <= 0+(T + mn * -1) );
      }else {
        //そうでない場合
        A = A.filter(_ <= 0 + T - mn );
      }
      //昇順に並び替える
      A = A.sorted
      //Aの中から組み合わせを作成
      var B = A.combinations(2).toArray
      //組み合わせの中から条件に合致する数値が存在するか調べる
      //昇順に並び変えているので、組み合わせの数は必ずA[i]<A[j]となり、かつ重複の組み合わせは無い。
      //iとjで繰り返し処理で探すより効率が良い。
      var flag = false
      breakable {
        B.foreach( { i =>
        if(i.sum == K ){
          var flag = true
          //最初にヒットした時点で検索を終了
          break
          }
        })
      }
      if(flag == true){
        println("条件を見たす組み合わせは存在する")
      }else{
        println("条件を見たす組み合わせは存在しない")
      }
    }
  }
   