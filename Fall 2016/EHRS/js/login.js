/**
 * Created by maxmya on 11/8/16.
 */

const email = document.querySelector('#email');
const password = document.querySelector('#password');

const dialogforErrors = document.querySelector('#err_dialog');
const dialogforLoading = document.querySelector('#loading');
const errTxt = dialogforErrors.querySelector('#err');


const btn = document.querySelector('#btn');
var admin = false;
var patients = false;
var doctors = false;
var logistics = false;

btn.addEventListener('click', function () {


    const mailTxt = email.value;
    const passTxt = password.value;

    if (!dialogforLoading.showModal) {
        dialogPolyfill.registerDialog(dialogforLoading);
    }
    dialogforLoading.showModal();


    dialogforErrors.querySelector('#close').addEventListener('click', function () {
        dialogforErrors.close();
    });


    if (mailTxt != "" && passTxt != "") {

        try {

            var dataRef = firebase.database().ref("admins");
            var flag = false;

            dataRef.once('value').then(function (snap) {

                snap.forEach(function (childSnapshot) {

                    var key = childSnapshot.key;
                    var childData = childSnapshot.val();

                    if (mailTxt == childData.email) {

                        const auth = firebase.auth();
                        const promise = auth.signInWithEmailAndPassword(mailTxt, passTxt);

                        promise.catch(function (e) {

                            dialogforLoading.close();
                            errTxt.innerHTML = e.message;
                            if (!dialogforErrors.showModal) {
                                dialogPolyfill.registerDialog(dialogforErrors);
                            }
                            dialogforErrors.showModal();

                        });

                        flag = true;
                        admin = true;
                    }
                });

                if (!flag) {


                    var partnerDataRef = firebase.database().ref('patients');
                    var pFlag = false;
                    partnerDataRef.once('value').then(function (dataSnap) {

                        dataSnap.forEach(function (datum) {

                            var key = datum.key;
                            var childData = datum.val()

                            if (mailTxt == childData.email) {

                                const auth = firebase.auth();
                                const promise = auth.signInWithEmailAndPassword(mailTxt, passTxt);

                                promise.catch(function (e) {

                                    dialogforLoading.close();
                                    errTxt.innerHTML = e.message;
                                    if (!dialogforErrors.showModal) {
                                        dialogPolyfill.registerDialog(dialogforErrors);
                                    }
                                    dialogforErrors.showModal();

                                });

                                pFlag = true;
                                patients = true;

                            }

                        })

                        if (!pFlag) {

                            var partnerDataRef = firebase.database().ref('doctors');
                            var dFlag = false;
                            partnerDataRef.once('value').then(function (dataSnap) {

                                dataSnap.forEach(function (datum) {

                                    var key = datum.key;
                                    var childData = datum.val()

                                    if (mailTxt == childData.email) {

                                        const auth = firebase.auth();
                                        const promise = auth.signInWithEmailAndPassword(mailTxt, passTxt);

                                        promise.catch(function (e) {

                                            dialogforLoading.close();
                                            errTxt.innerHTML = e.message;
                                            if (!dialogforErrors.showModal) {
                                                dialogPolyfill.registerDialog(dialogforErrors);
                                            }
                                            dialogforErrors.showModal();

                                        });

                                        dFlag = true;
                                        doctors = true;
                                    }
                                })
                                if (!dFlag) {

                                    var partnerDataRef3 = firebase.database().ref('nurses');
                                    var lFlag = false;
                                    partnerDataRef3.once('value').then(function (dataSnap) {

                                        dataSnap.forEach(function (datum) {

                                            var key = datum.key;
                                            var childData = datum.val()

                                            if (mailTxt == childData.email) {

                                                const auth = firebase.auth();
                                                const promise = auth.signInWithEmailAndPassword(mailTxt, passTxt);

                                                promise.catch(function (e) {

                                                    dialogforLoading.close();
                                                    errTxt.innerHTML = e.message;
                                                    if (!dialogforErrors.showModal) {
                                                        dialogPolyfill.registerDialog(dialogforErrors);
                                                    }
                                                    dialogforErrors.showModal();

                                                });

                                                lFlag = true;
                                                logistics = true;
                                            }
                                        })

                                        if (!lFlag) {

                                            dialogforLoading.close();
                                            errTxt.innerHTML = "invalid mail"
                                            if (!dialogforErrors.showModal) {
                                                dialogPolyfill.registerDialog(dialogforErrors);
                                            }
                                            dialogforErrors.showModal();

                                        }


                                    });


                                }
                            });

                        }

                    })


                }


            });


        } catch (e) {


            dialogforLoading.close();
            errTxt.innerHTML = e.message;
            if (!dialogforErrors.showModal) {
                dialogPolyfill.registerDialog(dialogforErrors);
            }
            dialogforErrors.showModal();

        }


    } else {

        errTxt.innerHTML = "Please Fill Missng Fields";
        dialogforLoading.close();
        if (!dialogforErrors.showModal) {
            dialogPolyfill.registerDialog(dialogforErrors);
        }
        dialogforErrors.showModal();
    }


});


firebase.auth().onAuthStateChanged(function (user) {
    if (user) {

        if (admin) {
            window.location.replace("home.html");
        } else if (patients) {
            window.location.replace("patients.html");
        } else if (doctors) {
            window.location.replace("doctors.html")
        } else if (logistics) {
            window.location.replace("logistics.html");
        }


    }
});

