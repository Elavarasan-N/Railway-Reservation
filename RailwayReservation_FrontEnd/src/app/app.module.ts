import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './pages/home/welcome/welcome.component';
import { AdminloginComponent } from './pages/login/adminlogin/adminlogin.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AdminhomeComponent } from './pages/home/adminhome/adminhome.component';
import { TrainlistComponent } from './pages/list/trainlist/trainlist.component';
import { CustomerlistComponent } from './pages/list/customerlist/customerlist.component';
import { BookinglistComponent } from './pages/list/bookinglist/bookinglist.component';
import { PaymentlistComponent } from './pages/list/paymentlist/paymentlist.component';
import { AddtrainComponent } from './pages/register/addtrain/addtrain.component';
import { UpdatetrainComponent } from './pages/register/updatetrain/updatetrain.component';
import { ContactusComponent } from './pages/home/contactus/contactus.component';
import { AboutusComponent } from './pages/home/aboutus/aboutus.component';
import { CustomerloginComponent } from './pages/login/customerlogin/customerlogin.component';
import { CustomerregisterComponent } from './pages/register/customerregister/customerregister.component';
import { CustomerhomeComponent } from './pages/home/customerhome/customerhome.component';
import { CustomerprofileComponent } from './pages/register/customerprofile/customerprofile.component';
import { BooktrainComponent } from './pages/register/booktrain/booktrain.component';
import { AddtravellerComponent } from './pages/register/addtraveller/addtraveller.component';
import { PaymentComponent } from './pages/register/payment/payment.component';
import { ReceiptComponent } from './pages/receipt/receipt.component';
import { ViewcustomerbookingComponent } from './pages/list/viewcustomerbooking/viewcustomerbooking.component';
import { ForgetComponent } from './pages/home/forget/forget.component';
import { PrivacyComponent } from './pages/home/privacy/privacy.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { UpdatecustomerComponent } from './pages/register/updatecustomer/updatecustomer.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { WalletComponent } from './pages/home/wallet/wallet.component';
import { AddmoneyComponent } from './pages/register/addmoney/addmoney.component';
import { AccountprofileComponent } from './pages/register/accountprofile/accountprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    AdminloginComponent,
    AdminhomeComponent,
    TrainlistComponent,
    CustomerlistComponent,
    BookinglistComponent,
    PaymentlistComponent,
    AddtrainComponent,
    UpdatetrainComponent,
    ContactusComponent,
    AboutusComponent,
    CustomerloginComponent,
    CustomerregisterComponent,
    CustomerhomeComponent,
    CustomerprofileComponent,
    BooktrainComponent,
    AddtravellerComponent,
    PaymentComponent,
    ReceiptComponent,
    ViewcustomerbookingComponent,
    ForgetComponent,
    PrivacyComponent,
    HeaderComponent,
    FooterComponent,
    UpdatecustomerComponent,
    WalletComponent,
    AddmoneyComponent,
    AccountprofileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    NgxPaginationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
