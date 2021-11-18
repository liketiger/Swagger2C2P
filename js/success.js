var cancelParam = {
    paymentToken:
      "kSAops9Zwhos8hSTSeLTUaZRFU0dixjVnk7f2UA6UaV+wgb6f9y6NZ9mSHiW6envNwV/XN+4cfJy56xZqHcN50Zno67F++V1N+IgxsGVTSWCLnMHdQolRmUZHkz8Uec9",
    clientID: "855ca0eeed4248af960bdef71151cd82",
    invoiceNo: "",
  };

var paymentActionParam = {
  version: "3.4",
  merchantID: "458458000001107",
};

var refundParam = {
  invoiceNo: "",
  actionAmount:"",
};

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