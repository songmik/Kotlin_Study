package com.example.kotlinstudy


// Kotlin 알고리즘을 위한 문법 공부

/*
1. 변수 : 값을 담아두는 박스
  - val : 박스 안에 값을 넣고, 테이프로 밀봉한 것 -> 값 변경 불가
  - var : 박스 안에 값으 넣고, 그대로 냅둔 것



2. 숫자
  1) println("123") = 123(문자)
     println(123)   = 123(숫자)

  2) println("123"+4) = 1234 ('4'가 문자 처리되어 글자 뒤에 글자가 붙은 것)
     println(123+4)   = 127  ( 숫자의 합)

     => println("123") -> string(문자)
        println(123)   -> int(숫자)

3. 자료형
 - 숫자와 문자가 헷갈릴 때 println(변수::class.java.simpleName) = string or int 로 출력 -> 숫자인지 문자인지 알 수 있음
 - 숫자를 문자로 변경 : .toString(), 문자를 숫자로 변경 : Integer.parseInt(변수) or .toInt()
 - ""와 null은 다르다. ""는 빈 문자열이고, null은 아무것도 없는 것


4. 조건문 : if-else , when

5. 리스트
  1) 리스트 생성 방법 1
    val testList = ArrayList<String>()
    testList.add("a")
    testList.add("b")
    testList.add("c")
    println(testList) = [a,b,c]

  2) 리스트 생성 방법 2
    val testList2 = listOf("a","b","c")
    println(testList2) = [a,b,c]

  3) 리스트 생성 방법 3
    val testList3 = mutableListOf<String>("a","b","c")
    println(testList3) = [a,b,c]

    -> 2와 3의 차이 : listOf는 문자를 더하거나 뺄 수 없음.
                      문자를 더하거나 뺄 때는 mutableOf를 써야함

   4) 필터 : 원하는 값만 얻고 싶을 때
   val testList4 = listOf("student1","student2","student3","teacher1")
   println(testList4) = ["student1","student2","student3","teacher1"]

   println(testList4.filter{it.startWith("s")}) = ["student1","student2","student3"]
   ( .filter대신 .filterNotNull()을 추가하면 리스트에 null 값을 뺴고 필터링해줌)



6. ?와 !!
    val test1 : String = "a"
    val test2 : String ?= "b"  -> '?'을 사용하면 null일 수도 있기 때문에 에러가 발생한다.
    test1 = test2!!            -> 이를 방지하기 위해 !!을 써주면 에러없이 값이 잘 나온다.
    println(test1) = b



7. 반복문
    for ( i in range) {

    }

    (1). range -> 반복할 변수 이름이나 숫자를 입력
    (2). 1..10 -> 1~10까지 반복
    (3). 1..10 step 2 -> 1부터 2만큼 점프 (1,3,5,7,9)



8. Map, Set
    (1). Map : 여러 개의 값이 있을 때, 원하는 값을 찾을 때 사용( Index를 이용할 때보다 더 빠르고 간단)
       - 방법 1
          val test1 = mutableMapOf<Int, String>()
          test1.put(5. "유리")
          test1.put(10. "철수")
          test1.put(15. "짱구")
          println(test1[15]) = 짱구

       - 방법 2
          val test1 = mutableMapOf<Int, String>()
          test1[5] = "유리1"
          test1[5] = "유리2"
          test1[5] = "유리3"
          println(test1) = {5=유리1, 15=유리2, 25=유리3}

    (2). Set : 중복되는 값을 없애줌
        val test2 = mutableSetOf("a", "b", "c")
        test2.add("c")
        test2.add("d")
        println(test2) = ["a","b","c","d"]
        test2.remove("a")
        println(test2) = ["b","c","d"]



9. 조건문

   (1) while(조건) {
                블럭 -> 블럭 내용 반복
     }

   (2) iterator
      val test2 = mutableListOf("a","b","c")
      val iterator = test2. listIterator()
      println(iterator.next()) = a        (next() -> jump)
      println(iterator.hasnext()) = true  ( 다음에 값이 있냐 없냐, 있으면 true 없으면 false)
      println(iterator.next()) = b
      println(iterator.next()) = a



*** 문제 ***
Q. 50점 이상인 사람들의 이름을 출력하세요
 val student = mutableMapOf<Int, String>()
 student[99] = "민지"
 student[20] = "철수"
 student[100] = "하영"

 val testList = ArrayList<String>()
 for(i in student) {
    if(i.key >= 50) {
        println(i.value)
        testList.add(i.value) -> testList에 50점 이상인 사람의 이름을 더해준코드
        }
    }
    println(testList)

    --------------------
    민지
    하영
    {민지, 하영}

    --------------------

    * key = 점수, value = 이름


10. 함수
    fun main(){
        val sumValue = sum(20, 40)
        println(sumValue)
     }
     fun sum(num1 : Int, num2 : Int) : Int {       (마지막 : Int 부분은 리턴 값을 정의한 부분임 )
        val result = num1 + num2
        return result

    --------------------
    148에 sum(20,40) 실행끝나고 153에 return 값을 돌아가라


11. 논리연산
   (1) AND : 둘 다 만족일 때 true( a == "남자" && b >= 20)
   (2) OR : 둘 중 하나만 만족일 때 true ( a == "남자" || b >= 20)



12. 문자열 가공 : 유저가 입력한 데이터를 가공하거나 서버에서 가져온 데이터를 알맞게 가공해서 쓸 때 사용
    - 문자열 자르기 " split(자를 부분) "
      val test = "동해물과 백두산이 마르고 닳도록"
      val newTestString = test.split(" ")
      println(newTestString) = [동해물과, 백두산이, 마르고, 닳도록] -> 공백을 자르고 리스트로 변환

    - 원하는 부분만 잘라서 가져오기 "substring(시작, 끝)" ** 끝은 포함 x
      val test = "동해물과 백두산이 마르고 닳도록"



 */