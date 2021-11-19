let drul1List = document.querySelectorAll(".drul1 > li");
let drul2List = document.querySelectorAll(".drul2 > li");

let drPlaceholder1 = document.getElementById("dropdownMenuButton1");
let drPlaceholder2 = document.getElementById("dropdownMenuButton2");

let currencyCode;
let paymentChannel;
let merchantID;
let invoiceNo;

let desc = document.querySelector(".description > h3").textContent;
let amt = document.querySelector(".description > h5").textContent;
let amt2 = document.querySelector(".description > h5").textContent;

amt = amt.substring(amt.length - 2);

let btn_2C2P = document.querySelector(".btn-2C2P");

let curCode = drPlaceholder1.textContent;

let ran = parseInt(Math.random() * 10000000000);

let cancBtn = document.querySelector(".canc-btn");
let inqBtn = document.querySelector(".inq-btn");

var paymentToken = {
  merchantID: "702702000001662",
  invoiceNo: ran.toString(),
  description: desc,
  amount: parseFloat(amt).toFixed(2),
  currencyCode: "",
  paymentChannel: [""],
  paymentToken: "",
  responseReturnUrl: "",
  channelCode: "",
	name: "",
	email: "",
	mobileNo: "",
	accountNo: "",
  }


let responseParam = {
  invoiceNo: "12345",
  channelCode: "GRAB",
  respCode: "2000",
  respDesc: "Transaction is complete you are finished",
};


for (const i of drul1List) {
  let ctx = i.textContent.split("-")[0].replace(" ", "");
  i.addEventListener("click", () => {
    unfilter();
    drPlaceholder2.textContent = "PaymentChannel";
    drPlaceholder1.textContent = ctx;
    paymentToken.currencyCode = ctx;
    curCode = ctx;
    midSet(curCode);
    drPlaceholder2.removeAttribute("disabled");
    filtering(ctx);
  });
}

for (const i of drul2List) {
  let ctx = i.textContent.split("-")[0].replace(" ", "");
  i.addEventListener("click", () => {
    drPlaceholder2.textContent = ctx;
    paymentToken.paymentChannel = [];
    paymentToken.paymentChannel.push(ctx);
    paymentToken.doPayment.payment.code.channelCode = ctx;
  });
}

function filtering(curCode) {
  for (const i of drul2List) {
    if (i.classList.contains(curCode) || i.classList.contains("gl")) {
      i.style.display = "block";
    }
  }
}

function unfilter() {
  for (const i of drul2List) {
    i.style.display = "none";
  }
}

function midSet(curCode) {
  switch (curCode) {
    case "SGD":
      paymentToken.merchantID = "702702000001670";
      break;
    case "PHP":
      paymentToken.merchantID = "608608000000685";
      break;
    case "MYR":
      paymentToken.merchantID = "458458000001107";
      break;
    case "MMK":
      paymentToken.merchantID = "104104000000550";
      break;
    case "THB":
      paymentToken.merchantID = "764764000009889";
      break;
    case "VND":
      paymentToken.merchantID = "704704000000046";
      break;
  }
}


function submitRequestParameter() {
console.log("submitRequestParameter");
  paymentToken.name = document.getElementById("name").value;
  paymentToken.email = document.getElementById("email").value;
  paymentToken.mobileNo = document.getElementById("phone").value;
  paymentToken.accountNo = document.getElementById("account").value;
  	
  	console.log(paymentToken);
  $.ajax({
    url: encodeURI("/payment.jsp"),
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(paymentToken),

  });
}

