import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable()
export class HttpService {

    constructor(private http: HttpClient) {
    }

    get(url: string): Observable<any> {

        return this.http.get(url)
            .pipe(
                map((data: Array<any>[]) => {
                    return data;
                }), catchError( error => {
                    return throwError(error)
                })
            )
    }
}