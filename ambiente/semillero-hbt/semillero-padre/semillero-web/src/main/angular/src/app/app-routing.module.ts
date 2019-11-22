import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { ModificarComicComponent } from './semillero/componentes/gestionarComic/modificarComic/modificar-comic-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ComicDTO } from './semillero/dto/comic.dto';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'visualizar-comic', component: ModificarComicComponent, data : ComicDTO },
  { path: '**', redirectTo: 'bienvenida' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
