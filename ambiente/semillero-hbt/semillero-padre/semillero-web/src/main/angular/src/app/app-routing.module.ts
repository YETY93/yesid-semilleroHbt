import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { ModificarComicComponent } from './semillero/componentes/gestionarComic/modificarComic/modificar-comic-component';
import { ModificarUsuariosComponent } from './semillero/componentes/gestionarUsuarios/modificarUsuarios/modificar-usuarios-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ComicDTO } from './semillero/dto/comic.dto';
import { GestionarUsuariosComponent } from './semillero/componentes/gestionarUsuarios/gestionar-usuarios';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'gestionar-usuarios', component: GestionarUsuariosComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'visualizar-comic', component: ModificarComicComponent, data : ComicDTO },
  { path: 'visualizar-usuario', component: ModificarUsuariosComponent, data : ComicDTO },
  { path: '**', redirectTo: 'bienvenida' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
