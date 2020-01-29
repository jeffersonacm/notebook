import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'favorite',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../favorite/favorite.module').then(m => m.FavoritePageModule)
          }
        ]
      },
      {
        path: 'contact',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../contact/contact.module').then(m => m.ContactPageModule)
          }
        ]
      },
      {
        path: 'call',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../call/call.module').then(m => m.CallPageModule)
          }
        ]
      },
      {
        path: '',
        redirectTo: '/tabs/favorite',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/favorite',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
