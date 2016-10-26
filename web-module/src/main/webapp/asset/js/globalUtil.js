/**
 * Created by Meng Sheng on 2016/9/24.
 */
/**
 * 自定义公共函数
 * */

    /**
     * 校验手机号码
     * phone：手机号码
     * return：返回提示信息
     * */
    var check_TellPhone = function (phone) {
        var reg = /^1[3|4|5|7|8][0-9]\d{8}$/,
            result = {msg: "", flag: true};
        if (!phone) {
            result = {msg: "手机号码不能为空！", flag: false};
            return result;
        }
        if (phone.indexOf(" ") != -1) {
            result = {msg: "手机号码不能含空格", flag: false};
            return result;
        }
        if (phone.length != 11) {
            result = {msg: "请输入11位的手机号码", flag: false};
            return result;
        }
        if (!reg.test(phone)) {
            result = {msg: "手机号码格式不正确", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验短信验证码
     * msg_code：短信验证码
     * return：返回提示信息
     * */
    var check_MsgCode = function (msg_code) {
        var reg = /^[0-9]{4}$/,
            result = {msg: "", flag: true};
        if (!msg_code) {
            result = {msg: "验证码不能为空", flag: false};
            return result;
        }
        if (msg_code.indexOf(" ") != -1) {
            result = {msg: "验证码不能含空格", flag: false};
            return result;
        }
        if (!reg.test(msg_code)) {
            result = {msg: "验证码格式不正确", flag: false};
            return result;
        }
        if (msg_code.length != 4) {
            result = {msg: "请输入4位数的验证码", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验密码
     * pass：密码
     * return：返回提示信息
     * */
    var check_PassWord = function (pass) {
        var reg = /^[A-Za-z0-9]{6,18}$/,
            length = pass.length,
            result = {msg: "", flag: true};
        if (!pass) {
            result = {msg: "密码不能为空", flag: false};
            return result;
        }
        if (pass.indexOf(" ") != -1) {
            result = {msg: "密码不能含空格", flag: false};
            return result;
        }
        if (length < 6 || length > 18) {
            result = {msg: "请输入6位到18位数的密码", flag: false};
            return result;
        }
        if (!reg.test(pass)) {
            result = {msg: "密码格式不正确", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验新密码
     * pass：密码
     * pass_new: 新密码
     * return：返回提示信息
     * */
    var check_PassWord_New = function (pass, pass_new) {
        var reg = /^[A-Za-z0-9]{6,18}$/,
            length = pass_new.length,
            result = {msg: "", flag: true};
        if (!pass_new) {
            result = {msg: "密码不能为空", flag: false};
            return result;
        }
        if (pass_new.indexOf(" ") != -1) {
            result = {msg: "密码不能含空格", flag: false};
            return result;
        }
        if (length < 6 || length > 18) {
            result = {msg: "请输入6位到18位数的密码", flag: false};
            return result;
        }
        if (!reg.test(pass_new)) {
            result = {msg: "密码格式不正确", flag: false};
            return result;
        }
        if (pass_new == pass) {
            result = {msg: "新密码不能与原密码相同", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验确认密码
     * pass：密码
     * pass_rep: 确认密码
     * return：返回提示信息
     * */
    var check_PassWord_Rep = function (pass, pass_rep) {
        var reg = /^[A-Za-z0-9]{6,18}$/,
            length = pass_rep.length,
            result = {msg: "", flag: true};
        if (!pass_rep) {
            result = {msg: "密码不能为空", flag: false};
            return result;
        }
        if (pass_rep.indexOf(" ") != -1) {
            result = {msg: "密码不能含空格", flag: false};
            return result;
        }
        if (length < 6 || length > 18) {
            result = {msg: "请输入6位到18位数的密码", flag: false};
            return result;
        }
        if (!reg.test(pass_rep)) {
            result = {msg: "密码格式不正确", flag: false};
            return result;
        }
        if (pass_rep != pass) {
            result = {msg: "两次密码不相同", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 检验邀请码
     * code：邀请码
     * return：返回提示信息
     * */
    var check_inviteCode = function (code) {
        var reg = /^[A-Za-z0-9]$/,
            result = {msg: "", flag: true};
        if (code.indexOf(" ") != -1) {
            result = {msg: "邀请码不能含空格", flag: false};
            return result;
        }
        if (!reg.test(code)) {
            result = {msg: "邀请码格式不正确", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验姓名
     * name：姓名
     * return：返回提示信息
     * */
    var check_Name = function (name) {
        var reg = /^[\u4e00-\u9fa5]+$/,//只能是中文
            result = {msg: "", flag: true};
        if (!name) {
            result = {msg: "姓名不能为空", flag: false};
            return result;
        }
        if (!reg.test(name)) {
            result = {msg: "姓名格式不正确", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验身份证号码
     * card_ID：身份证号码
     * return：返回提示信息
     * */
    var check_Person_cardID = function (card_ID) {
        var reg = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/,
            result = {msg: "", flag: true};
        if (!card_ID) {
            result = {msg: "身份证不能为空", flag: false};
            return result;
        }
        if (card_ID.indexOf(" ") != -1) {
            result = {msg: "身份证不能含空格", flag: false};
            return result;
        }
        if (!reg.test(card_ID)) {
            result = {msg: "身份证格式不正确,身份证为15或18位数", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 校验银行卡号
     * bankCardNo：银行卡号
     * return：返回提示信息
     * */
    var check_BankCard_No = function (bankCardNo) {
        var reg = /^[0-9]\d{15,19}$/,
            length = bankCardNo.length,
            result = {msg: "", flag: true};
        if (!bankCardNo) {
            result = {msg: "银行卡号不能为空", flag: false};
            return result;
        }
        if (bankCardNo.indexOf(" ") != -1) {
            result = {msg: "银行卡号不能含空格", flag: false};
            return result;
        }
        if (length < 15 || length > 19) {
            result = {msg: "银行卡的位数为15到19位", flag: false};
            return result;
        }
        if (!reg.test(bankCardNo)) {
            result = {msg: "银行卡格式不正确", flag: false};
            return result;
        }
        return result;
    }

    /**
     * 检验手机号码是否已注册
     * phone: 手机号码
     * url: 对应controller的地址
     * status： 已注册：0 未注册：1
     * */
    var check_Tell_reg = function (phone) {
        var result = {msg: "", flag: true};
        $.ajax({
            type: "POST",
            url: "/user/safe/checkTellExist",
            dataType: "json",
            async: false,
            data: {
                tel_phone: phone
            },
            success: function (data) {
                var status = data['status'];
                if (status == 1) {
                    console.log("手机号码未注册");
                    result = {msg: "手机号码未注册", flag: false};
                } else if (status == 0) {
                    console.log("手机号码已注册！");
                    result = {msg: "手机号码已注册", flag: true};
                }
            }
        });
        return result;
    }

    /**
     * 发送手机验证码
     * phone: 手机号码
     * url: 对应controller的地址
     * */
    var sendMsgCode_AJAX = function (phone, url) {
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            data: {
                tel_phone: phone
            },
            success: function (data) {
                var status = data['status'];
                if (status == 0) {
                    console.log("验证码已经发送");
                } else if (status == 1) {
                    alert("系统异常,短信发送未成功！");
                }
            }
        });
    }

    /**
     * 注册发送手机验证码
     * phone: 手机号码
     * url: 对应controller的地址
     * */
    var reg_sendMsgCode_AJAX = function (phone, url) {
        $.ajax({
            type: "POST",
            url: url,
            dataType: "json",
            data: {
                tel_phone: phone
            },
            success: function (data) {
                var status = data['status'];
                if (status == 0) {
                    console.log("验证码已经发送");
                } else if (status == 2) {
                    alert("系统异常！");
                    return;
                }
            }
        });
    }


