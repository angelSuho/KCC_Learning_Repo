/**
 * 인스턴스 __proto__ 변경
 * 
 */
function IdolModel(name, year) {
    this.name = name;
    this.year = year;
}

IdolModel.prototype.sayHello = function () {
    return `${this.name}이(가) 인사합니다.`;
}

function FemaleIdolModel(name, year) {
    this.name = name;
    this.year = year;

    this.dance = function() {
        return `${this.name}이(가) 춤을 춥니다.`;
    }
}

const gaeul = new IdolModel('김가을', 2004);
const ray = new FemaleIdolModel('김레이', 2004);

console.log(gaeul.__proto__);
console.log(gaeul.__proto__ === IdolModel.prototype);

console.log(gaeul.sayHello());
console.log(ray.dance());
// console.log(ray.sayHello()); // Error
Object.setPrototypeOf(ray, IdolModel.prototype);
console.log(ray.sayHello()); // no Error

console.log(ray.constructor === IdolModel);
console.log(ray.constructor === FemaleIdolModel);

console.log(gaeul.constructor === IdolModel);
console.log(gaeul.constructor === FemaleIdolModel);
console.log(FemaleIdolModel.prototype === IdolModel.prototype);

/**
 * 함수의 프로토타입 객체 변경
 */
FemaleIdolModel.prototype = IdolModel.prototype;
const eSeo = new FemaleIdolModel('이서', 2007);
console.log(Object.getPrototypeOf(eSeo) === FemaleIdolModel.prototype);
console.log(FemaleIdolModel.prototype === IdolModel.prototype);
console.log(eSeo.sayHello());
