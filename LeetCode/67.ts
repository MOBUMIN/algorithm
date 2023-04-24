function addBinary(a: string, b: string): string {

    return (BigInt("0b" + a) + BigInt("0b" + b)).toString(2);
};

// GPT에게 위 코드 성능 개선해달라고 했는데, 개선한 코드보다 내 코드가 더 좋았다 ㅋ
// 아래는 gpt가 개선해준 코드
/*
function addBinary(a: string, b: string): string {
  let carry = 0;
  let result = "";
  let i = a.length - 1;
  let j = b.length - 1;

  while (i >= 0 || j >= 0 || carry > 0) {
    const sum = (i >= 0 ? parseInt(a[i--], 2) : 0) + (j >= 0 ? parseInt(b[j--], 2) : 0) + carry;
    carry = sum >> 1;
    result = (sum % 2 ? "1" : "0") + result;
  }

  return result;
}
*/
