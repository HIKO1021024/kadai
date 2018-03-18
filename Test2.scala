/*
おそらくこの問題はいわゆる「組み合わせ」を問うものだと想定される。
よって母数をできる限り減らした上で、組み合わせのリストを生成し、
そのリストからA[i]<A[j]を精査する。
なお、与えられる配列は必ず2要素以上入っているものを想定している
*/
import scala.util.Random
import scala.util.control.Breaks

  object Kumiawase{
    def main(args: Array[String]){
      //まずはランダムな配列AとKを作成
      val r = new Random
      //var A: Array[Int] = Array(1,2,3,4,5) //存在しない場合のテスト用
      var A: Array[Int] = Array.empty
      for(i <- 0 to 3000) A = A :+ r.nextInt(100)
      val K = r.nextInt(100)
      //最低値からKへの必要な数値を算出
      val T = K - A.min
      //A.min・←ここまでには最低限必要値Tが必要→・K
      //つまり、A[i]orA[j]が最低限必要値Tよりも大きな数値は現時点で不要と判断できるため、削除する
      //さらに昇順に並び替える
      //そしてAの中から組み合わせを作成
      var B = A.filter(_ <= T).sorted.combinations(2).toArray
      //組み合わせの中から条件に合致する数値が存在するか調べる
      //昇順に並び変えているので、組み合わせの数は必ずA[i]<A[j]となり、かつ重複の組み合わせは無い。
      var flag = false
      val b = new Breaks
      b.breakable {
        B.foreach( { i =>
          if(i.sum == K ){
            flag = true
            //最初にヒットした時点で検索を終了(処理速度向上のため)
            b.break
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