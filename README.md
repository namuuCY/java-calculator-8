# java-calculator-precourse

# TODO List

- [x] 프로젝트 세팅 및 README.md 정리
- [x] 각종 컨벤션 및 요구사항 정리
- [x] 기본 테스트 요구사항 및 `camp.nextstep.edu.missionutils` 확인해보기
    - [x] CustomException, ErrorCode 작성
    - [x] IllegalArgumentException을 상속한 클래스에서도 동작하는지 확인해보기
- [x] Parser 구현
    - [x] ParserTest 작성
    - [x] Parser 작성
        - [정규 표현식 리서치](https://stackoverflow.com/questions/5993779/use-string-split-with-multiple-delimiters)
- [ ] StringCalculator 구현
    - [ ] StringCalculatorTest 작성
    - [ ] StringCalculator 작성
- [ ] InputView 구현
- [ ] OutputView 구현
    - [ ] OutputViewTest 작성
    - [ ] OutputView 작성
- [ ] CalculatorController 구현
- [ ] AppConfig 구현
- [ ] ApplicationTest(통합테스트) 작성
- [ ] mermaid 및 소감문 작성

## 프로그래밍 요구 사항

- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다 - 기본적으로 **Java Style Guide**를 원칙으로 한다.

## 라이브러리

- [x] `camp.nextstep.edu.missionutils` 에서 제공하는 Console API를 사용하여 구현해야 한다.
- [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 과제 진행 요구 사항

- [x] 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- [x] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.

기능 요구 사항
---

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# **커밋 메시지 형식**

[커밋 컨벤션 출처](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#allowed-type)

기본적인 형식은 다음과 같습니다.

```
<type>(<scope>): <subject>

<body>

<footer>
```

* 모든 줄은 100자를 넘지 않아야 합니다.

### **1. Subject (제목)**

제목 줄은 `<type>(<scope>): <subject>` 형식입니다.

* **`<type>`**: 커밋의 유형을 나타냅니다.
    * `feat`: 새로운 기능
    * `fix`: 버그 수정
    * `docs`: 문서
    * `style`: 코드 스타일 (포맷팅, 세미콜론 등)
    * `refactor`: 코드 리팩토링
    * `test`: 테스트 추가
    * `chore`: 유지보수 (빌드 스크립트 수정 등)
* **`<scope>`** (선택 사항): 커밋이 변경한 부분의 범위를 나타냅니다. (예: `$location`, `$browser`, `ngHref` 등)
* **`<subject>`**: 변경 사항에 대한 간결한 설명입니다.
    * **명령형, 현재 시제**를 사용합니다. (예: "change" - "changed"나 "changes" X)
    * 첫 글자를 대문자로 쓰지 않습니다.
    * 끝에 마침표(.)를 찍지 않습니다.

### **2. Body (본문)**

* 제목(Subject)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **왜** 이 변경 사항이 필요한지, 그리고 **이전 동작과 어떻게 다른지** 설명합니다.
* 제목과 마찬가지로 명령형, 현재 시제를 사용합니다.

### **3. Footer (꼬리말)**

* 본문(Body)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **Breaking Changes (주요 변경 사항)**: 하위 호환성을 깨뜨리는 변경 사항이 있다면 `BREAKING CHANGE:` 키워드로 시작하여 설명, 정당성, 마이그레이션 노트를 포함해야 합니다.
* **Referencing Issues (이슈 참조)**: 닫힌 이슈가 있다면 `Closes #123` 또는 `Closes #123, #245`와 같이 별도의 줄에 기재합니다.