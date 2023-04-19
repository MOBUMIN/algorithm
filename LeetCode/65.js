/**
 * @param {string} s
 * @return {boolean}
 */
const INTEGER_PATTERN = /^[+-]?\d+$/;
const DECIMAL_PATTERN = /^[+-]?(\d+(\.\d*)?|\.\d+)$/;

function isNumber(s) {
  // 주어진 문자열 s가 null, 빈 문자열인 경우 false 반환
  if (s === null || s.length === 0) {
    return false;
  }

  // 문자열 s 앞뒤의 공백 제거
  s = s.trim();

  // 문자열 s에서 e/E의 인덱스 찾기
  let eIndex = s.toLowerCase().indexOf('e');

  // e/E가 없는 경우, 소수점 숫자인지 검사
  if (eIndex === -1) {
    return isDecimal(s);
  }

  // e/E가 있는 경우, 정수와 소수점 숫자를 구분하여 검사
  else {
    let left = s.substring(0, eIndex);
    let right = s.substring(eIndex + 1);

    // e/E 앞쪽이 소수점 숫자이고, 뒤쪽이 정수인지 검사
    if (isDecimal(left) && isInteger(right)) {
      return true;
    }

    // e/E 앞쪽이 정수이고, 뒤쪽이 정수 또는 음수인지 검사
    else if (isInteger(left)) {
      return isInteger(right) || (right[0] === '-' && isInteger(right.substring(1)));
    }

    // 그 외의 경우는 유효하지 않은 숫자이므로 false 반환
    else {
      return false;
    }
  }
}

// 주어진 문자열이 소수점 숫자인지 검사하는 함수
function isDecimal(s) {
  // 문자열 s를 숫자열로 변환하여 검사
  let num = parseFloat(s);
  return !isNaN(num) && DECIMAL_PATTERN.test(s);
}

// 주어진 문자열이 정수인지 검사하는 함수
function isInteger(s) {
  // 문자열 s를 숫자열로 변환하여 검사
  let num = parseInt(s);
  return !isNaN(num) && INTEGER_PATTERN.test(s);
}
