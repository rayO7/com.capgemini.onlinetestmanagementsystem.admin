import { Component, OnInit } from '@angular/core';
import { Test } from '../Test';
import { ConfigService } from '../config.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  testId:number
  topic:string
  totalMarks:number
  minMarks:number
  duration:number
  sTime:string
  eTime:string
  constructor(private service:ConfigService, private router:Router) { }
  add()
  {
    this.service.add("http://localhost:8080/test/addTest",new Test(this.testId, this.topic, this.totalMarks, this.minMarks, this.duration, this.sTime, this.eTime)).subscribe(data=>{
      //alert(data)
      console.log(data)
      this.router.navigate(['/SubjectListComponent'])
    });
  }


  ngOnInit(): void {
  }

}
