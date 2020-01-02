import { Component, OnInit, OnChanges } from '@angular/core';
import { FormService } from 'src/app/services/form.service';
import { NgForm } from '@angular/forms';
import { ModelHead } from 'src/app/models/modelHead';

@Component({
  selector: 'hdr-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  id : number
  headerType: ModelHead;

  constructor(private service: FormService) { }

  ngOnInit() {
  }



  addUrl(f : NgForm){
    console.log(f.form.value.url)
    console.log(f.form.value.method)
    this.service.postUrl( f.form.value.method,f.form.value.url).subscribe(
      risp =>{
        console.log(risp)
        this.id = risp.id
        this.getHeadByid(this.id)
      }
      , (err) => {
        alert(err.error.data);
        console.log(err);
      }
    )
  }


getHeadByid(id: number){
  return  this.service.getById(id).subscribe(
    risp => {
      console.log("sono qui",risp)
      this.headerType = risp
    }
  )
}
 
}
