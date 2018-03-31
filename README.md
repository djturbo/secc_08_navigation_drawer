# Navigation Drawer
Se aprende como trabajar con los menu laterales conocidos en Android como Navigation Drawer.

# Links
https://developer.android.com/training/implementing-navigation/nav-drawer.html?hl=es-419

# Primeros pasos
importar las siguiente dependencias en el gradle del modulo
    compile 'com.android.support:design:26.1.0'
    compile 'com.android.support:support-v4:26.1.0'
    
# Como mostrar el menu lateral
## 1. Mostrar Icono en el ActionBar
    
    Se consigue con estos tres métodos que se llaman en el onCreate
    
    setSupportActionBar(this.toolbar);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

## 2. Capturar el pulsado del botón de abrir menú
    
    Se abre capturando el evento del tab en el botón de abrir menú, implementando el método 
    onOptionsItemSelected
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    
        boolean res = true;
    
        switch(item.getItemId()){
            case android.R.id.home:
                this.drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                res = super.onOptionsItemSelected(item);
    
        }
        return res;
    
    }