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
    val testList2 = listOf("a", "b", "c")
    println(testList2) = [a,b,c]

  3) 리스트 생성 방법 3
    val testList3 = mutableListOf<String>("a", "b", "c")
    println(testList3) = [a,b,c]

    -> 2와 3의 차이 : listOf는 문자를 더하거나 뺄 수 없음.
                      문자를 더하거나 뺄 때는 mutableOf를 써야함

   4) 필터 : 원하는 값만 얻고 싶을 때
    val testList4 = listOf("student1", "student2", "student3", "teacher1")
    println(testList4) = ["student1","student2","student3","teacher1"]

    println(testList4.filter{ it.startWith("s") }) = ["student1","student2","student3"]
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

(1). Map : 여러 개의 값이 있을 때, 원하는 값을 찾을 때 사용(Index를 이용할 때보다 더 빠르고 간단)


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
    println(test1) = { 5 = 유리1, 15 = 유리2, 25 = 유리3 }



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
    val test2 = mutableListOf("a", "b", "c")
    val iterator = test2.listIterator()
    println(iterator.next()) = a        (next() -> jump)
    println(iterator.hasnext()) = true  ( 다음에 값이 있냐 없냐, 있으면 true 없으면 false)
    println(iterator.next()) = b
    println(iterator.next()) = a



*** 문제 ***
Q. 50점 이상인 사람들의 이름을 출력하세요.

val student = mutableMapOf<Int, String>()
student[99] = "민지"
student[20] = "철수"
student[100] = "하영"

val testList = ArrayList<String>()
for(i in student) {
    if (i.key >= 50) {
        println(i.value)
        testList.add(i.value)  ->testList에 50점 이상인 사람의 이름을 더해준코드
    }
}
println(testList)

--------------------
민지
하영
{ 민지, 하영 }

--------------------

* key = 점수, value = 이름



10. 함수

fun main() {
    val sumValue = sum(20, 40)
    println(sumValue)
}

fun sum(num1: Int, num2: Int): Int {
    //(마지막 : Int 부분은 리턴 값을 정의한 부분임)
    val result = num1 + num2
    return result
}

/*
 --------------------
 148 에 sum(20, 40) 실행끝나고 153 에 return 값을 돌아가라


11.논리연산

(1) AND : 둘 다 만족일 때 true(a == "남자" && b >= 20)
(2) OR : 둘 중 하나만 만족일 때 true(a == "남자" || b >= 20)


12.문자열 가공 : 유저가 입력한 데이터를 가공하거나 서버에서 가져온 데이터를 알맞게 가공해서 쓸 때 사용

-문자열 자르기 " split(자를 부분) "
    val test = "동해물과 백두산이 마르고 닳도록"
    val newTestString = test.split(" ")
    println(newTestString) = [동해물과, 백두산이, 마르고, 닳도록] -> 공백을 자르고 리스트로 변환

-원하는 부분만 잘라서 가져오기 "substring(시작, 끝)" * * 끝은 포함 x
    val test = "동해물과 백두산이 마르고 닳도록"
    val split = test.substring(0, 2) -> '0'번째부터 '2'번째 전까지 = 0~1까지 출력 => 동해
    println(split) = 동해

-일부분을 바꾸기 "replace(바꾸고 싶은 부분, 바꾸고 싶은 내용)"
    val test = "동해물과 백두산이 마르고 닳도록"
    val replace = test.replace("백두산", "한라산")
    println(replace) = 동해물과 한라산이 마르고 닳도록


13.엘비스 연산자 (Elvis Operator)

-null : 아무 것도 없는 것 -> null 처리 할 때는 "?" 붙이는 것 잊지 말기
fun findString(str: String): Int {
    return str?.length ?: 0    -> 값이 null이면 0을 리턴해주고, 아니면 str?.length 문자열의 길이를 리턴해줘라
}


14.Any / is / as

  -Any
  -is -> 맞나 ? 확인
  -as -> type casting (타입 변경 / 체크)


15.list 가공하기

    -중복제거 : .distinct()
    -제일 큰 값 : .maxOrNull()
    -제일 작은 값 : .minOrNull()
    -평균값 : .average()
    -필터
        val test = listOf("john", "jay", "minsu", "minji")
        val result = test.filter {
            it.startsWith("j")
        }
        println(result) = [john, jay]
    -결과를 묶어줌 : .groupBy {}


16.Class(function -> 기능, class -> 설계+기능)
fun main_2{
    val dog = Dog("파트라슈", 10)
    println(dog.getMyDogInfo())    //-> 클래스를 만들고, 그 안에 함수를 외부에서 가져옴
}

class Dog(name: String, age: Int) {
    val dogName = name
    val dogAge = age

    fun getMyDogInfo(): String {
        return "$dogName : $dogAge "
    }

17. 오버로딩 (overloading) : 겹겹히 쌓는다 (부모 클래스의 메소드를 자식 클래스에서 재정의해서 사용할 수 있음)
   -> 후에 생긴 함수의 조건에 따라 값이 변함


 18. 상속 (Inheritance) : 물려받는다 (자식 클래스가 부모 클래스의 멤버를 물려받음)

    -class 앞에 open을 붙임


    open class AllJobs() {
    }

    class Job() : AllJobs() {                  -> (:AllJobs()가 상속받는다는 뜻)
    }


19. 추상클래스 ( abstract class)

 - class -> 붕어빵틀
 - abstract class -> 기존에는 비어있고, 꽉 채워서 붕어빵을 만들어야 하는 틀
 - 공통적으로 기능을 구현해주어야 할 때 사용


    fun main_3() {
        BMW().wheel()
        BMW().engine()
    }

    abstract class Car {
        abstract fun wheel()
        abstract fun engine()
    }

    class BMW() : Car {
        override fun wheel() {
            println("BMW 굴러갑니다.")
        }

        override fun engine() {
            println("BMW 시동걸립니다.")
        }
    }


20. 인터페이스( interface) : 추상클래스랑 비슷, 꼭 채워넣어야 하는 붕어빵 틀인데 작은 틀이라서 여러개를 넣을 수 있음

    fun main() {
        BMW().autoDriving()
    }

    abstract Car() {
        abstract fun wheel()
        abstract fun engine()
    }

    interface CarAutoDriving {
        fun autoDriving()
    }

    interface CarAutoParking {
        fun autoParking()
    }

    class BMW() : Car(), CarAutoDriving, CarAutoParking {
        override fun wheel() {
            println("BMW 굴러감")
        }

        override fun engine() {
            println("BMW 엔진시동")
        }

        override fun autoDriving() {
            println("BMW 자율 주행")
        }

        override fun autoParking() {
            println("BMW 자동 주차")
        }
    }



21. 데이터 클래스 (Data Class) : 서버에서 데이터 받아온 것을 넣어 놓을 때 사용
    (class랑 같음, 서버에서 받아온다는 것이 차이점)


22. 중첩 클래스 ( Nasted class) , 내부 클래스 ( Inner class)

 - 중첩 클래스 -> 객체지향, 캡슐화 -> 외부에 있는 클래스로 접근 불가능
 - 내부 클래스 -> RecyclerView -> 내부 클래스에 있는걸 가져와서 사용할 수 있음


23. 람다 ( lambda ) : 선언되지 않았지만, 즉시 표현식으로 전달되는 함수
    fun main() {
        println(sum(1, 2))
        println(sumNumber(1, 2))
        println(sumTypeNumber(1, 2))
    }

    1번 : 일반식
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    2번 : 람다를 사용해 간단히 표현
    val sumNumber = { a: Int, b: Int -> a + b }
    val sumTypeNumber: (Int, Int) -> Int = { a, b -> a + b }
    위 아래 식 둘 다 동일하게 쓸 수 있음.


24. 고차함수(High-order Function) : f(x) = x -> f(f(x)) = x처럼 표현이 되어야 함

    fun main() {
        sum(1, 2, { a: Int, b: Int -> a + b })
        sum(1, 2) { a: Int, b: Int -> a + b }
        sum(1, 2, ::testSum)  // 가져오고 싶은 function 앞에 ::를 붙여서 고차 함수로 가져옴

    }

    fun sum(a: Int, b: Int, operation: (Int, Int) -> Int) {
        println("$a $b")
        println(operation(a, b))
    }

    fun testSum(a: Int, b: Int): Int {
        return a + b
    }

25. 제네릭(Generic) :  컴파일 시 타입 체크를 할 수 있다, 타입캐스팅이 필요 없다.

    fun main() {
        val box = Box(10)
        println(box.value)
    }

    class Box<T>(test: T) {
        val value = test
    }

    -> Int, String 처럼 타입을 쓰지 않고, <T>를 이용해 넣는 값에 따라 알아서 타입을 체크해 줌


26.object : 싱글톤 패턴(디자인 패턴 중 하나) -> 객체를 한 개만 생성하도록 함 (전역으로 사용 가능)

    fun main() {
        val test1 = TestClass()
        val test2 = TestClass()
        val test3 = testObject
        val test4 = testObject
        test3, test4를 만들어도 object는 객체를 한 개만 생성하도록 하기 때문에 한 문장만 출력이 됌
    }

    object testObject {
        init {
            println("testObject")
        }
    }

    class TestClass {
        init {
            println("testClass")
        }

        companion object {
            // 클래스 안에서 object를 사용할 때는 companion object라고 함
        }
    }


27. 지연초기화 (lateninit / lazy)

   fun main() {

        lateinit
        lateinit var lateString: String
        lateString = "변경된 스트링"
        println(lateString)  // 나중에 값을 입력해줌, 값이 변경 가능
        서버에서 받아온 데이터를 넣어두고 싶을 때, 미리 변수를 선언해놓고
        나중에 서버에서 값을 받아와서 넣어줄 때 주로 사용 .


        lazy
        val lazyString: String by lazy {
            "lazyString"
        }
        println(lazyString)
        값 변경 불가능
    }

*/


 */

// 28. infix function (중위 함수) : 중간에 끼어 넣는 함수라고 생각하면 된다. 숫자, 문자 상관없이 가능

fun main(){
    println(10 sum1 20)
}

// 방법1
infix fun Int.sum1(num: Int) :Int = this + num

// 방법2
infix fun Int.sum3(num: Int) : Int {
    return this + num
}

fun sum(a: Int, b:Int) : Int {
    return a+b
}

//29. Kotlin scope function( let / with / run / apply / also )

// let : non null일 때 블럭안에 있는 함수 실행, 값이 null이면 함수가 동작하지 않음

// with : 컨텍스트 내부에서 함수를 호출

// run : 객체 초기화와 return 값 계산이 필요할 때 주로 사용

// apply : 값을 반환하지 않고, 객체 구성에 대해 주로 사용

// also : 객체에 대해 추가적인 작업



//30. enum class : 값을 열거해서 사용할 때 사용
fun main(){
    println(Direction.NORTH)

    // 값을 다 출력하고 싶을 때때
   Direction.values().forEach {
        println(it)
    }
}

enum class Direction{
    NORTH, SOUTH, WEST, EAST
}


// ---------------------------------------------- //

// 코틀린으로 알고리즘 연습하기

// 1.