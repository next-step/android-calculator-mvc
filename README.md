# MVC - 단위 테스트, UI 테스트

## 🚀 3단계 - 문자열 계산기

### 기능 요구 사항
- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구 사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 기능 구현 목록

**StringCalculator**

- [x] 사칙연산 기호 하나가 포함된 문자열의 계산 결과값을 알 수 있다
- [x] 사칙연산 기호 여러 개가 포함된 문자열의 계산 결과값을 알 수 있다
- [x] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException이 발생한다
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다

**Number**

- [x] 두 숫자는 덧셈 연산을 할 수 있다
- [x] 두 숫자는 뺄셈 연산을 할 수 있다
- [x] 두 숫자는 곱하기 연산을 할 수 있다
- [x] 두 숫자는 나누기 연산을 할 수 있다

## 🚀 4단계 - 계산기 UI

### 기능 요구 사항
- [x] 입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
- [x] 입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다. 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다.
- [x] 입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
- [x] 입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다.
- [x] 입력된 수식이 없을 때, 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다.
- [x] 입력된 수식이 있을 때, 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다.
- [x] 입력된 수신이 완전할 때, 사용자가 = 버튼을 누르면 입력된 수식의 결과가 화면에 보여야 한다.
- [ ] 입력된 수식이 완전하지 않을 때, 사용자가 = 버튼을 눌렀을 때 완성되지 않은 수식입니다 토스트 메세지가 화면에 보여야 한다.

### 프로그래밍 요구사항
- 모든 기능 요구 사항에 대한 UI 테스트를 구현한다.
- 단, 토스트 메세지에 대한 테스트는 제외한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
