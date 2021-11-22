var paymentActionParam = {
  version: "3.4",
  merchantID: "702702000001670",
  actionAmount: "0.0",
};

function submitInquiryParameter(){
  paymentActionParam.invoiceNo = document.getElementById('invoice').value;
  paymentActionParam.processType = "I";
  $.ajax({
    url: encodeURI("/paymentAction.jsp"),
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(paymentActionParam),
    success: function (data, textStatus, xhr) {
      window.location = xhr.getResponseHeader("Location");
    },
  });
}

function submitCancelParameter() {
  paymentActionParam.invoiceNo = document.getElementById('invoice').value;
  paymentActionParam.processType = "V";
  $.ajax({
    url: encodeURI("/paymentAction.jsp"),
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(paymentActionParam),
    success: function (data, textStatus, xhr) {
      window.location = xhr.getResponseHeader("Location");
    },
  });
}

 function refundAction() {
  paymentActionParam.invoiceNo = document.getElementById('invoice').value;
  paymentActionParam.actionAmount = document.getElementById('amount').value;
  paymentActionParam.processType = "R";
  console.log(paymentActionParam);
  $.ajax({
    url: encodeURI("/paymentAction.jsp"),
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(paymentActionParam),
    success: function (data, textStatus, xhr) {
      window.location = xhr.getResponseHeader("Location");
    },
  });
}

function refundStatus() {
  paymentActionParam.invoiceNo = document.getElementById('invoice').value;
  paymentActionParam.processType = "RS";
  console.log(paymentActionParam);
  $.ajax({
    url: encodeURI("/paymentAction.jsp"),
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(paymentActionParam),
    success: function (data, textStatus, xhr) {
      window.location = xhr.getResponseHeader("Location");
    },
  });
}