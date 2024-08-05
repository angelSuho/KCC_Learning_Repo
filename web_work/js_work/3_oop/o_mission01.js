/**
 * 과제1 > 
 * 1. Rectangle 생성자함수를 class 기반으로 수정하세요.
 * 2. 상속을 이용해서 Square 클래스를 구현해 보세요.
 */
// 기존 Rectangle 생성자함수
/**
 * 
 * function Rectangle(width, height) {
    this.width = width;
    this.height = height;
    this.getArea = function () {
        return this.width * this.height;
    }
}
 */
// class 기반으로 수정
class Rectangle {
    width;
    height;

    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    getArea() {
        return this.width * this.height;
    }
}

// 상속을 이용한 Square 클래스 구현
class Square extends Rectangle {
    type;

    constructor(width, type) {
        super(width, width);
        this.type = type;
    }

    getArea() {
        return `정사각형의 넓이는 ${super.getArea()} 입니다.`;
    }
}

const rect = new Rectangle(10, 20);
console.log(rect.getArea());
const square = new Square(10, '정사각형');
console.log(square.getArea());

console.log(rect instanceof Rectangle);
console.log(square instanceof Square);
