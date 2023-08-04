import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './pages/home/welcome/welcome.component';
import { AdminloginComponent } from './pages/login/adminlogin/adminlogin.component';
import { AdminhomeComponent } from './pages/home/adminhome/adminhome.component';
import { TrainlistComponent } from './pages/list/trainlist/trainlist.component';
import { AddtrainComponent } from './pages/register/addtrain/addtrain.component';
import { UpdatetrainComponent } from './pages/register/updatetrain/updatetrain.component';
import { ContactusComponent } from './pages/home/contactus/contactus.component';
import { AboutusComponent } from './pages/home/aboutus/aboutus.component';
import { CustomerloginComponent } from './pages/login/customerlogin/customerlogin.component';
import { CustomerregisterComponent } from './pages/register/customerregister/customerregister.component';
import { CustomerlistComponent } from './pages/list/customerlist/customerlist.component';
import { CustomerhomeComponent } from './pages/home/customerhome/customerhome.component';
import { CustomerprofileComponent } from './pages/register/customerprofile/customerprofile.component';
import { BooktrainComponent } from './pages/register/booktrain/booktrain.component';
import { AddtravellerComponent } from './pages/register/addtraveller/addtraveller.component';
import { PaymentComponent } from './pages/register/payment/payment.component';
import { ReceiptComponent } from './pages/receipt/receipt.component';
import { BookinglistComponent } from './pages/list/bookinglist/bookinglist.component';
import { PaymentlistComponent } from './pages/list/paymentlist/paymentlist.component';
import { ViewcustomerbookingComponent } from './pages/list/viewcustomerbooking/viewcustomerbooking.component';
import { ForgetComponent } from './pages/home/forget/forget.component';
import { PrivacyComponent } from './pages/home/privacy/privacy.component';
import { FooterComponent } from './component/footer/footer.component';
import { UpdatecustomerComponent } from './pages/register/updatecustomer/updatecustomer.component';
import { WalletComponent } from './pages/home/wallet/wallet.component';
import { AddmoneyComponent } from './pages/register/addmoney/addmoney.component';
import { AccountprofileComponent } from './pages/register/accountprofile/accountprofile.component';

const routes: Routes = [
  {path:'',component:WelcomeComponent},
  {path:'welcomepage',component:WelcomeComponent},
  {path:'customerlogin',component:CustomerloginComponent},
  {path:'customerhome/:customerId',component:CustomerhomeComponent},
  {path:'updatecustomer/:customerId',component:UpdatecustomerComponent},
  {path:'privacy',component:PrivacyComponent},
  {path:'profile/:customerId',component:CustomerprofileComponent},
  {path:'customerregister',component:CustomerregisterComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'adminhome',component:AdminhomeComponent},
  {path:'customerlist',component:CustomerlistComponent},
  {path:'trainlist',component:TrainlistComponent},
  {path:'bookinglist',component:BookinglistComponent},
  {path:'paymentlist',component:PaymentlistComponent},
  {path:'viewbookinglist/:customerId',component:ViewcustomerbookingComponent},
  {path:'addtrain',component:AddtrainComponent},
  {path:'updatetrain/:trainId',component:UpdatetrainComponent},
  {path:'booktrain/:trainId/:customerId/:accountId',component:BooktrainComponent},
  {path:'contact',component:ContactusComponent},
  {path:'aboutus',component:AboutusComponent},
  {path:'wallet/:customerId',component:WalletComponent},
  {path:'accountprofile/:accountId',component:AccountprofileComponent},
  {path:'money/:accountId',component:AddmoneyComponent},
  {path:'addtraveller',component:AddtravellerComponent},
  {path:'payment/:trainId/:customerId/:accountId/:bookingId',component:PaymentComponent},
  {path:'paymentreceipt/:trainId/:customerId/:bookingId/:paymentId',component:ReceiptComponent},
  {path:'forgot',component:ForgetComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
