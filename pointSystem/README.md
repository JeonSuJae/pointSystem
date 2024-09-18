# 무료 포인트 시스템

# Table of Contents
- [[1] About the Project](#1-about-the-project)
  - [Features](#features)
  - [Technologies](#technologies)
- [[2] Getting Started](#2-getting-started)
  - [빌드](#빌드)
  - [실행](#실행)
- [[3] Usage](#3-usage)
- [[4] Contact](#4-contribution)



# [1] About the Project
*무료 포인트 시스템

## Features
- a. 적립 기능 
- b. 적립 취소 기능
- c. 포인트 사용 기능
- d. 포인트 사용 취소 기능

## Technologies

- Java 21
- SpringBoot 3.3.3
- H2

# [2] Getting Started
## 빌드
- 로컬 Maven 빌드

## 실행
- 빌드 후 로컬호스트로 실행
- 웹 브라우저(크롬)에서 localhost:8080으로 접근
- API별 Front 메뉴를 이용해 기능 사용


# [3] Usage
- 적립
1. a.적립 메뉴에서 적립 input에 적립할 포인트 금액을 입력, 수기 지급여부를 체크, 만료일(기본365일)을 적은 뒤 적립 버튼 클릭 시 적립.
2. 1회 최대 적립 가능 포인트는 application.properties에 point.min, point.max로 제어가능.
3. 최대 적립 가능 무료 포인트는 Users 테이블 max_point 필드로 제어 가능.
4. 적립된 포인트는 Point 테이블에 적립별로 조회 가능.
5. 수기 지급여부는 Front 웹 브라우저 수기 지급 체크박스를 통해 선택 가능하며 Point 테이블에 manual 필드로 식별 가능.
6. 만료일은 Front 웹 브라우저 만료일 inputBox를 통해 작성 가능(기본 365일)하며 Point 테이블 end_date 필드로 관리 가능.

- 적립 취소
1. b. 적립 취소 메뉴에서 취소 적립 selectBox를 선택해 취소 가능하며 (포인트키 - 포인트) 형태로 구성.
2. 특정 적립행위에서 적립한 금액만 취소 가능하도록 (포인트키 - 포인트) 형태로 구성.
3. 적립한 금액 중 일부가 사용된 경우 적립 취소가 불가능하도록 selectBox에 나타나지 않음.

- 사용
1. c. 사용 메뉴에서 사용 포인트를 inputBox에 설정함으로써 사용 가능.
2. 포인트 사용 시 UseHistory 테이블에 이력이 남으며 주문번호(order_num)를 통해 어떤 주문에서 얼마의 포인트가 사용되었는지를 식별할 수 있음.
3. 포인트 사용 시 Point 테이블의 manual 필드를 통해 관리자가 수기 지급한 포인트가 먼저 사용되며 end_date 필드를 통해 만료일이 짧게 남은 순서로 사용됨.

- 사용 취소
1. d. 사용 취소 메뉴에서 사용 취소 포인트를 inputBox에 설정함으로써 사용 가능.
2. 사용한 금액 중 전체 또는 일부를 사용 취소 가능.
3. 사용 시점에서 이미 만료된 포인트를 사용 취소해야 한다면 그 금액만큼 신규 사용 이력을 UseHistory테이블에 기록.

# [4] Contact
- 📧 pshke@naver.com

<!--Url for Badges-->
[license-shield]: https://img.shields.io/github/license/dev-ujin/readme-template?labelColor=D8D8D8&color=04B4AE
[repository-size-shield]: https://img.shields.io/github/repo-size/dev-ujin/readme-template?labelColor=D8D8D8&color=BE81F7
[issue-closed-shield]: https://img.shields.io/github/issues-closed/dev-ujin/readme-template?labelColor=D8D8D8&color=FE9A2E

<!--Url for Buttons-->
[readme-eng-shield]: https://img.shields.io/badge/-readme%20in%20english-2E2E2E?style=for-the-badge
[view-demo-shield]: https://img.shields.io/badge/-%F0%9F%98%8E%20view%20demo-F3F781?style=for-the-badge
[view-demo-url]: https://dev-ujin.github.io
[report-bug-shield]: https://img.shields.io/badge/-%F0%9F%90%9E%20report%20bug-F5A9A9?style=for-the-badge
[report-bug-url]: https://github.com/dev-ujin/readme-template/issues
[request-feature-shield]: https://img.shields.io/badge/-%E2%9C%A8%20request%20feature-A9D0F5?style=for-the-badge
[request-feature-url]: https://github.com/dev-ujin/readme-template/issues

<!--URLS-->
[license-url]: LICENSE.md
[contribution-url]: CONTRIBUTION.md
[readme-eng-url]: ../README.md



