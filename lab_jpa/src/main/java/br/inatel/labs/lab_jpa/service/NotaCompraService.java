package br.inatel.labs.lab_jpa.service;
import br.inatel.labs.lab_jpa.entity.NotaCompra;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;
import br.inatel.labs.lab_jpa.repository.NotaCompraItemRepository;
import br.inatel.labs.lab_jpa.repository.NotaCompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class NotaCompraService {

    @Autowired
    private NotaCompraRepository ncRepository;

    @Autowired
    private NotaCompraItemRepository nciRepository;


    //nota compra
    public NotaCompra salvarNotaCompra(NotaCompra nc) {
        return ncRepository.save(nc);
    }

    public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
        return ncRepository.findById(id);
    }

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
        Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
        if(opNotaCompra.isPresent()) {
            NotaCompra notaCompra = opNotaCompra.get();
            notaCompra.getListaCompraItem().size();
            return notaCompra;
        } else {
            throw new RuntimeException("Nenhuma nota compra encontrada");
        }
    }

    public List<NotaCompra> listarNotaCompra(){
        return ncRepository.findAll();
    }

    //nota compra item
    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
        return nciRepository.save(item);
    }

    public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
        return nciRepository.findById(id);
    }

    public List<NotaCompraItem> listarNotaCompraItem(){
        return nciRepository.findAll();
    }
}
