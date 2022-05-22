import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './components/index/index.component';
import { ProductoFormComponent } from './components/producto-form/producto-form.component';
import { ProductosComponent } from './components/productos/productos.component';

const routes: Routes = [
  { path: '', component: ProductosComponent },
  { path: 'formulario', component: ProductoFormComponent },
  { path: 'formulario/:id', component: ProductoFormComponent },
  { path: 'index', component: IndexComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
