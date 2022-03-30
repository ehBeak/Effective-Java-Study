# item 20 설명

### 디폴트 메서드

- 인터페이스에 있는 **구현 메서드**
- 추상 메서드와 다른 점
    - `default` 예약어를 붙임
    - 구현부 `{}` 가 있어야 함
- 예제
    
    ```java
    public interface Interface {
       // 추상 메서드 
        void abstractMethodA();
        void abstractMethodB();
        void abstractMethodC();
    
    	// default 메서드
        default int defaultMethodA(){
        	...
        }
    }
    ```
    
- 장점
    - 복잡한 형태의 인터페이스와 구현체가 있을 경우 이를 해결 할 수 있음
- 문제점
    - 인터페이스에 추상메서드를 추가하게 되면 모든 구현체에 구현을 해야함
    - 해결 방안 : 인터페이스에 defatul method를 사용하면 추가 변경을 막을 수 있음

> 참고
https://velog.io/@heoseungyeon/%EB%94%94%ED%8F%B4%ED%8A%B8-%EB%A9%94%EC%84%9C%EB%93%9CDefault-Method

### 믹스인(mixin)

- 다른 클래스에서 사용할 목적으로 만들어진 클래스
- 특정 클래스에 작성된 기능들을 다른 클래스와 혼합
- 믹스인 클래스는 필요로 하는 기능들을 포함하는 상위 클래스로서의 역할을 함. 하위 클래스는 이 기능을 상속하거나 단순히 재사용 가능. 자식 클래스를 특수화하는 수단으로는 사용 불가 (포함 관계)
- 장점
    - 다중 상속의 메커니즘을 제공하지만 다중 상속의 복잡한 의미론은 제거 가능
    - 코드 재사용성 : 동일한 코드를 반복해서 작성하는 대신 공통 기능을 믹스인으로 그룹화하고 이 기능을 필요로하는 다른 클래스들에 추가 가능
    - 부모클래스의 모든 기능을 상속하지 않고 필요로 하는 기능만 상속하고 사용 가능
- 예제
    
    ```java
    public interface Singer {
        AudioClip sing(Song s);
    }
    
    public interface Songwriter {
        Song compose(int chartPosition);
    }
    ```
    
    - 두 개의 별개의 인터페이스가 있음
    - `Sing` 과 `Songwriter` 의 기능을 혼합
    
    ```java
    public interface SingerSongwriter extends Singer, Songwriter {
        AudioClip strum();
        void actSensitive();
    }
    ```
    
- Comparable 인터페이스는 믹스인 인터페이스. 비교라는 기능을 혼합

> 참고 https://jake-seo-dev.tistory.com/30

### 템플릿 메서드 패턴

- 어떤 작업을 처리하는 일부분을 서브 클래스로 캡슐화해 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴
- 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 코드 중복을 최소화
- 동일한 기능을 상위 클래스에 정의, 확장/변화가 필요한 부분만 서브 클래스에서 구현
- 장점
    - 중복 코드를 줄일 수 있음
    - 자식 클래스의 역할을 줄여 핵심 로직의 관리가 용이
    - 코드를 좀더 객체지향적으로 구성 가능
- 단점
    - 추상 메소드가 많아지면서 클래스 관리가 복잡해짐
    - 클래스 간의 관계와 코드가 꼬여버릴 염려가 있음
- 예제
    - 추상 클래스 - 선생님
    
    ```java
    abstract class Teacher {
    
    		public void start_class() {
            inside();
            attendance();
            teach();
            outside();
        }
    
    		// 공통 메서드
        public void inside() {
            System.out.println("선생님이 강의실로 들어옵니다.");
        }
        
        public void attendance() {
            System.out.println("선생님이 출석을 부릅니다.");
        }
        
        public void outside() {
            System.out.println("선생님이 강의실을 나갑니다.");
        }
    
    		// 추상 메서드
        abstract void teach();
    }
    ```
    
    - 국어 선생님
    
    ```java
    class Korean_Teacher extends Teacher {
        
        @Override
        public void teach() {
            System.out.println("선생님이 국어를 수업합니다.");
        }
    }
    ```
    
    - 수학 선생님
    
    ```java
    class Math_Teacher extends Teacher{
    
        @Override
        public void teach() {
            System.out.println("선생님이 수학을 수업합니다.");
        }
    }
    ```
    
    ```java
    public class Main {
        public static void main(String[] args) {
            Korean_Teacher kr = new Korean_Teacher(); //국어
            Math_Teacher mt = new Math_Teacher(); //수학
            English_Teacher en = new English_Teacher(); //영어
            
            kr.start_class();
            System.out.println("----------------------------");
            mt.start_class();
            System.out.println("----------------------------");
            en.start_class();
        }
    }
    ```
    
    - 설명
        - 수업하는 과정은 동일, 어떤 수업을 하는지가 달라짐
        - 추상 클래스에 함수의 기본 틀을 정의하고, 공통 알고리즘을 구성한 뒤, 하위 클래스에 구현해야할 기능을 추상 메서드를 상속받아 정의
            
            → teach() 메서드만 자식에서 구현하면 됨
            
    > 참고
    https://coding-factory.tistory.com/712
    
    ### 추상 골격 클래스
    
    ```java
    public interface Coffee {
        void boilWater();
        void putEspresso();
        void putIce();
        void putExtra();
        void makeCoffee();
    }
    ```
    
    ```java
    public class IceAmericano implements Coffee{
        @Override
        public void boilWater() {
            System.out.println("물을 끓인다.");
        }
    
        @Override
        public void putEspresso() {
            System.out.println("에스프레소를 넣는다.");
        }
    
        @Override
        public void putIce() {
            System.out.println("얼음을 넣는다.");
        }
    
        @Override
        public void putExtra() {
            System.out.println("시럽을 넣는다.");
        }
    }
    ```
    
    ```java
    public class IceLatte implements Coffee{
        @Override
        public void boilWater() {
            System.out.println("물을 끓인다.");
        }
    
        @Override
        public void putEspresso() {
            System.out.println("에스프레소를 넣는다.");
        }
    
        @Override
        public void putIce() {
            System.out.println("얼음을 넣는다.");
        }
    
        @Override
        public void putExtra() {
            System.out.println("우유를 넣는다.");
        }
    }
    ```
    
    - `Coffee` 를 구현한 `IceAmericano` 와 `IceLatte` 클래스
    - 마지막 putExtra()만 다르고 위의 세 메소드는 동일한 형태
    
    → 코드 중복을 제거해보자
    
    ```java
    public abstract class AbstractCoffee implements Coffee{
        @Override
        public void boilWater() {
            System.out.println("물을 끓인다.");
        }
    
        @Override
        public void putEspresso() {
            System.out.println("에스프레소를 넣는다.");
        }
    
        @Override
        public void putIce() {
            System.out.println("얼음을 넣는다.");
        }
    }
    
    public class IceAmericano extends AbstractCoffee implements Coffee {
    
        @Override
        public void putExtra() {
            System.out.println("시럽을 넣는다.");
        }
    }
    
    public class IceLatte extends AbstractCoffee implements Coffee {
    
        @Override
        public void putExtra() {
            System.out.println("우유를 넣는다.");
        }
    }
    ```
    
    - `AbstractCoffe` 클래스는 추상 골격 클래스
    - 이를 통해 중복을 제거하고 읽기 좋은 코드가 됨
    
    - 여기서 카푸치노 클래스를 추가하고, 카푸치노 클래스는 MilkCream이라는 클래스를 상속받는다고 가정
        
        → 자바는 단일 상속만을 지원하기 때문에 AbstractCoffe 클래스(추상 골격 클래스)를 상속받지 못함
        
        → 이럴 때는 private 내부 클래스를 정의하고 내부 클래스가 추상 골격 클래스를 상속하도록 하면 됨
        
        → **시뮬레이트한 다중 상속**
        
    
    ```java
    public class MilkCream {
        public void putCream() {
            System.out.println("우유 크림을 넣는다.");
        }
    }
    ```
    
    ```java
    public class IceCappuccino extends MilkCream implements Coffee {
        InnerAbstractCoffee innerAbstractCoffee = new InnerAbstractCoffee();
    
        @Override
        public void boilWater() {
            innerAbstractCoffee.boilWater();
        }
    
        @Override
        public void putEspresso() {
            innerAbstractCoffee.putEspresso();
        }
    
        @Override
        public void putIce() {
            innerAbstractCoffee.putIce();
        }
    
        @Override
        public void putExtra() {
            innerAbstractCoffee.putExtra();
            putCream();
        }
    
        @Override
        public void makeCoffee() {
            boilWater();
            putEspresso();
            putIce();
            putExtra();
        }
    
    	// private 내부 클래스 - 추상 골격 클래스를 상속한다.
        private class InnerAbstractCoffee extends AbstractCoffee {
    
            @Override
            public void putExtra() {
                System.out.println("우유를 넣는다.");
            }
        }
    }
    ```
    
    `InnerAbstractCoffe` 라는 private 내부 클래스를 정의하고, 내부 클래스가 추상 골격 클래스를 상속하도록 함
    
    내부 클래스의 메서드를 인스턴스에서 호출하여 우회적으로 추상 골격 클래스를 사용할 수 있도록 함
    
    > 참고
        [https://intrepidgeeks.com/tutorial/java-abstraction-level-interface](https://intrepidgeeks.com/tutorial/java-abstraction-level-interface)